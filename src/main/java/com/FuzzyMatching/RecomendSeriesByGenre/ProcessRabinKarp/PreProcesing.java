package com.FuzzyMatching.RecomendSeriesByGenre.ProcessRabinKarp;

import com.FuzzyMatching.Estructure.Serie;

public class PreProcesing {
    public static String preProcesingGenres (Serie serie){
        StringBuilder genresStringBuilder = new StringBuilder();
        for (String genre : serie.getGenres()) {
            genresStringBuilder.append(genre).append(", ");
        }
        String genresString = genresStringBuilder.toString().replaceAll(", $", "");
        return genresString;
    }
}
