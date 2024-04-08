package com.FuzzyMatching.Menu.Commands;

import com.FuzzyMatching.Estructure.Serie;
import com.FuzzyMatching.Estructure.User;
import com.FuzzyMatching.Menu.Login;
import com.FuzzyMatching.Menu.Options;

import java.util.ArrayList;

public class LogOutCommand implements Command{
    @Override
    public void execute(ArrayList<Serie> serieList, ArrayList<User> usersList, User user) {
        Options.printOptionHeader("Log out");
        Login.login(serieList, usersList);
        Options.printOptionFooter();
    }
}
