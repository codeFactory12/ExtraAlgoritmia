package com.FuzzyMatching.Menu.Commands;

import com.FuzzyMatching.Estructure.Serie;
import com.FuzzyMatching.Estructure.User;

import java.util.ArrayList;

public interface Command {
    void execute(ArrayList<Serie> serieList, ArrayList<User> usersList, User user);
}
