package com.FuzzyMatching.RecomendSeriesByGenre;

import com.FuzzyMatching.Estructure.Serie;
import com.FuzzyMatching.Estructure.User;
import com.FuzzyMatching.RecomendSeriesByGenre.Match.GenreMatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Recomend {
    public static void RecomendationSeries(ArrayList<Serie> serieList, User user) {
        Map<String, Integer> recomendedSeries = GenreMatch.genreMatch(serieList, user.getlikedgenres());

        ArrayList<Map.Entry<String, Integer>> sortedEntries = sortSeries(recomendedSeries);

        printTop10Series(sortedEntries);
    }

    private static ArrayList<Map.Entry<String, Integer>> sortSeries(Map<String, Integer> seriesMap) {
        ArrayList<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(seriesMap.entrySet());

        Collections.sort(sortedEntries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });

        return sortedEntries;
    }

    private static void printTop10Series(ArrayList<Map.Entry<String, Integer>> sortedEntries) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            if (count >= 10) {
                break;
            }
            String serie = entry.getKey();
            System.out.println("*******************************************************************************************************************");
            System.out.println("Serie Title: " + serie);
            System.out.println("*******************************************************************************************************************");
            count++;
        }
    }}
