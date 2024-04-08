package com.FuzzyMatching.ExtraPoints;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderTxt {
    public static List<String> ReaderTxt() {
        String rutaArchivo = "src/main/resources/0_palabras_todas.txt";
        List<String> words = new ArrayList<>();

        try {
            File archivo = new File(rutaArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                words.add(linea);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}

