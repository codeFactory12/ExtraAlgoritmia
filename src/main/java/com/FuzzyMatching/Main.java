package com.FuzzyMatching;

import com.FuzzyMatching.Estructure.Serie;
import com.FuzzyMatching.Estructure.User;
import com.FuzzyMatching.Menu.Login;
import com.FuzzyMatching.ReadData.SeriesReader;
import com.FuzzyMatching.ReadData.UserReader;
import java.util.ArrayList;


public class Main {
    private static ArrayList<Serie> serieList = new ArrayList<>();
    private static ArrayList<User> usersList = new ArrayList<>();

    public static void main(String[] args) {
        SeriesReader.readToList(serieList);
        UserReader.readUsers(usersList);
        Login.login(serieList,usersList);
    }
}
