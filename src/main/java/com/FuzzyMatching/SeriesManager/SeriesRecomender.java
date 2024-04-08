package com.FuzzyMatching.SeriesManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.FuzzyMatching.Estructure.Serie;
import com.FuzzyMatching.ReadData.SeriesReader;
import com.intuit.fuzzymatcher.component.MatchService;
import com.intuit.fuzzymatcher.domain.Document;
import com.intuit.fuzzymatcher.domain.Element;
import com.intuit.fuzzymatcher.domain.ElementType;
import com.intuit.fuzzymatcher.domain.Match;

public class SeriesRecomender {
  private ArrayList<Serie> seriesList;
  private SeriesFinder serieFinder;
  private MatchService matchService;
  
  public SeriesRecomender(ArrayList<Serie> seriesList) {
    this.seriesList = seriesList;
    serieFinder = SeriesFinder.getInstance();
    matchService = new MatchService();
  }

  private Document getDocumentFromSerie(Serie serie) {
    return new Document.Builder(serie.getId())
        .addElement(
            new Element.Builder<Date>().setValue(
                serie.getDate()).setType(ElementType.DATE).createElement())
        .createDocument();
  }

  public void recommendLastSeries() {
    Document nowDocument =  new Document.Builder("now")
    .addElement(
        new Element.Builder<Date>().setValue(
            new Date()).setType(ElementType.DATE).createElement())
    .createDocument();
    List<Document> documentList = seriesList.stream().map(s -> getDocumentFromSerie(s))
        .collect(Collectors.toList());

    Map<String, List<Match<Document>>> result = matchService.applyMatchByDocId(nowDocument, documentList);
    result.forEach((key, value) -> value.sort((m1, m2) ->
    Double.compare(m2.getScore().getResult(), m1.getScore().getResult())));

    result.entrySet().forEach(entry -> entry.getValue().stream()
    .limit(5)
    .forEach(match -> {
        System.out.println(serieFinder.findSerie(match.getMatchedWith().getKey(), seriesList));
    }));

  }
  
}
