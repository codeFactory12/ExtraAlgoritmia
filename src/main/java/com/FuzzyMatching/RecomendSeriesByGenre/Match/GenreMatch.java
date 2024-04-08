package com.FuzzyMatching.RecomendSeriesByGenre.Match;

import com.FuzzyMatching.Estructure.Serie;
import com.FuzzyMatching.RecomendSeriesByGenre.ProcessRabinKarp.PreProcesing;
import com.FuzzyMatching.RecomendSeriesByGenre.ProcessRabinKarp.RabinKarp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GenreMatch {
    public static Map<String,Integer> genreMatch(ArrayList<Serie> serieList, String[] search){
        Map<String,Integer> matchesList= new HashMap<>();
        for(Serie serie: serieList){
            int matches = containsToken(serie,search);
            if(matches > 0 && serie.getRating() > 8.0){
              matchesList.put(serie.toString(),matches);
            }
        }
        return matchesList;
    }
    private static int containsToken(Serie serie, String[] search){
        int matches = 0;
        String serieGenres = PreProcesing.preProcesingGenres(serie);
        for(int i = 0; i < search.length; i++){
            if(RabinKarp.rabinExact(search[i],serieGenres,false)){
              matches = matches + 1;
            }
        }
        return matches;
    }
}
