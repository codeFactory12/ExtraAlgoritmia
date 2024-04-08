package com.FuzzyMatching.Estructure;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Serie {
    private String id;
    private String name;
    private String[] genres;
    private double rating;
    private Date premiered;

    private String summary;

    public Serie(String name, String[] genres, double rating, String date,String summary, String id) {
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.rating = rating;
        this.premiered = convertDate(date);
        this.summary = summary;
    }

    private Date convertDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
        return sdf.parse(dateString);
        } catch (Exception e) {
        return new Date();
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getGenres() {
        return genres;
    }


    public double getRating() {
        return rating;
    }

    public String getSummary(){
        return summary;
    }


    public Date getDate() {
        return premiered;
    }

    @Override
    public String toString() {
        String reset = "\u001B[0m";
        String blue = "\u001B[34m";

        StringBuilder genresStringBuilder = new StringBuilder();
        for (String genre : genres) {
            genresStringBuilder.append(genre).append(", ");
        }
        String genresString = genresStringBuilder.toString().replaceAll(", $", "");

        StringBuilder sb = new StringBuilder();
        sb.append("╔══════════════════════════════════════════════════════════════╗\n");
        sb.append("║                          Serie                               ║\n");
        sb.append("╠══════════════════════════════════════════════════════════════╣\n");
        sb.append("║ ").append(blue).append("name: ").append(reset).append(name);
        sb.append("\n║ ").append(blue).append("genres: ").append(reset).append(genresString);
        sb.append("\n║ ").append(blue).append("rating: ").append(reset).append(rating);
        sb.append("\n║ ").append(blue).append("premiered: ").append(reset).append(premiered);
        if (summary.length() > 50) {
            sb.append("\n║ ").append(blue).append("summary: ").append(reset).append(summary.substring(0, 50)).append("...");
        } else {
            sb.append("\n║ ").append(blue).append("summary: ").append(reset).append(summary);
        }
        sb.append("\n╚══════════════════════════════════════════════════════════════╝");
        return sb.toString();
    }
}
