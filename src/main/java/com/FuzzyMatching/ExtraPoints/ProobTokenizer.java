package com.FuzzyMatching.ExtraPoints;

import com.FuzzyMatching.RecomendSeriesByGenre.ProcessRabinKarp.RabinKarp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProobTokenizer {

    public static void wordsFeeder(List<String> words){
        Map<String, String> matches = new HashMap<>();
        for(int j = 0; j < 30000;j++){
            for(int i = 0; i < 30000; i++){
             if(!words.get(j).equals(words.get(i))){
                 if(RabinKarp.rabinExact(words.get(j), words.get(i), true)){
                     matches.put(words.get(j),words.get(i));
                     System.out.println("Clave: " + words.get(j) + ", Valor: " + words.get(i));
                 }
             }
            }
        }
    }

    public static  void main(String args[]){


        List<String> words = ReaderTxt.ReaderTxt();
        System.out.println("termino de leer");
        System.out.println("tamaño de la data: " + words.size() + " palabras");
        wordsFeeder(words);
        System.out.println("termino de analizar parte del texto");

        otherLenguages();
    }

    public static void otherLenguages (){
        String textMandarin = "天上的小白羊" +
                "天上一群小白羊，" +
                "有的站着有的躺" +
                "小白羊啊下来吧" +
                "不要在天上着了凉" +
                "地上河水清," +
                "地上草儿肥," +
                "地上才是你们的家乡。";
        String pathMandrin = "有的站着有的躺";

        String textRuso = "Са́мое холо́дное ме́сто в ми́ре – э́то ру́сская дере́вня Оймяко́н.";
        String pathRuso = "холо́дное";

        System.out.println("Mandarin: " + RabinKarp.rabinExact(pathMandrin,textMandarin, false));
        System.out.println("Ruso: " + RabinKarp.rabinExact(pathRuso,textRuso, false));
    }
}
