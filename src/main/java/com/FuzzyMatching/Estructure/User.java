package com.FuzzyMatching.Estructure;

import lombok.Getter;

/**
 * Represents a user with basic profile information.
 */
@Getter
public class User {
    private String id;
    private String username;
    private int age;
    private String[] likedGenres;
    private String[] likedTitles;

    /**
     * Constructs a new User object with the given parameters.
     *
     * @param id           the ID of the user
     * @param name         the username of the user
     * @param age          the age of the user
     * @param likedGenres  an array of genres liked by the user
     * @param likedTitles  an array of titles liked by the user
     */
    public User(String id, String name, int age, String[] likedGenres, String[] likedTitles) {
        this.id = id;
        this.username = name;
        this.age = age;
        this.likedGenres = likedGenres;
        this.likedTitles = likedTitles;
    }


    public String[] getlikedgenres(){
        return this.likedGenres;
    }

    public String getId( ){
        return this.id;
    }

    public int getAge(){
        return this.age;
    }
    /**
     * Generates a string representation of the user profile with formatted output.
     *
     * @return a string representation of the user profile
     */
    @Override
    public String toString() {
        String reset = "\u001B[0m";
        String blue = "\u001B[34m";

        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════╗\n");
        sb.append("║          User Profile          ║\n");
        sb.append("╠════════════════════════════════╣\n");
        sb.append("║ ").append(blue).append("UserId: ").append(reset).append(id);
        sb.append("\n║ ").append(blue).append("Name: ").append(reset).append(username);
        sb.append("\n║ ").append(blue).append("Age: ").append(reset).append(age);
        sb.append("\n║ ").append(blue).append("Liked Genres: ").append(reset);
        for (int i = 0; i < likedGenres.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(likedGenres[i]);
        }
        sb.append("\n╚════════════════════════════════╝");
        return sb.toString();
    }
}
