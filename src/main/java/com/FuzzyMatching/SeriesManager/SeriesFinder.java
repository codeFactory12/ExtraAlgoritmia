package com.FuzzyMatching.SeriesManager;

import java.util.ArrayList;

import com.FuzzyMatching.Estructure.Serie;

public class SeriesFinder {
  private static SeriesFinder instance;
  public static synchronized SeriesFinder getInstance() {
    if (instance == null) {
      instance = new SeriesFinder();
    }
    return instance;
  }
  public Serie findSerie(String id, ArrayList<Serie> seriesList) {
    for (Serie serie : seriesList) {
      if (serie.getId().equals(id)) {
        return serie;
      }
    }
    return null;
  }
}
