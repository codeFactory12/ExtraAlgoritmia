package com.FuzzyMatching.ReadData;

import com.FuzzyMatching.Estructure.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.util.ArrayList;

public class UserReader {

    public static ArrayList<User> readUsers(ArrayList<User> userList) {
        try {
            String filePath = "src/main/resources/users.json";
            FileReader reader = new FileReader(filePath);

            StringBuilder stringBuilder = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                stringBuilder.append((char) character);
            }
            String jsonString = stringBuilder.toString();

            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String username = jsonObject.getString("username");
                int age = jsonObject.getInt("age");
                JSONArray likedGenresArray = jsonObject.getJSONArray("likedGenres");
                String[] likedGenres = new String[likedGenresArray.length()];
                for (int j = 0; j < likedGenresArray.length(); j++) {
                    likedGenres[j] = likedGenresArray.getString(j);
                }
                JSONArray likedTitlesArray = jsonObject.getJSONArray("likedTitles");
                String[] likedTitles = new String[likedTitlesArray.length()];
                for (int j = 0; j < likedTitlesArray.length(); j++) {
                    likedTitles[j] = likedTitlesArray.getString(j);
                }

                User user = new User(id, username, age, likedGenres, likedTitles);
                userList.add(user);
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
}
