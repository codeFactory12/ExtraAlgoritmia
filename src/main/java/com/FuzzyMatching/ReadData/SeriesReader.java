package com.FuzzyMatching.ReadData;

import com.FuzzyMatching.Estructure.Serie;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;

public class SeriesReader {

    public static void readToList(ArrayList<Serie> serieList) {
        try {
            String filePath = "src/main/resources/tv-shows.json";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            String jsonString = stringBuilder.toString();

            JSONArray jsonArray = new JSONArray(jsonString);


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String name = jsonObject.getString("name");
                int id = jsonObject.getInt("id");

                String summary = jsonObject.getString("summary").replaceAll("<[/]?[pbPB]>", "");
                JSONArray genresArray = jsonObject.getJSONArray("genres");
                String[] genres = new String[genresArray.length()];

                for (int j = 0; j < genresArray.length(); j++) {
                    genres[j] = genresArray.getString(j);
                }

                BigDecimal rating = BigDecimal.ZERO;

                JSONObject ratingObject = jsonObject.optJSONObject("rating");
                if (ratingObject != null && !ratingObject.isNull("average")) {
                    rating = ratingObject.getBigDecimal("average");
                }
                String premiered = jsonObject.getString("premiered");

                serieList.add(new Serie(name,genres,rating.doubleValue(),premiered, summary,String.valueOf(id)));
            }

            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
