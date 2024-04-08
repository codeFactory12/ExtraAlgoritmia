package com.FuzzyMatching.Menu.Commands;

import com.FuzzyMatching.Estructure.Serie;
import com.FuzzyMatching.Estructure.User;
import com.FuzzyMatching.Menu.Options;
import com.FuzzyMatching.UsersManager.UsersRecommender;

import java.util.ArrayList;

public class RecommendUsersCommand implements Command {
    @Override
    public void execute(ArrayList<Serie> serieList, ArrayList<User> usersList, User user) {
        UsersRecommender usersRecommender = new UsersRecommender(usersList);
        Options.printOptionHeader("Top 5 similar users");
        usersRecommender.recommendUsers(user);
        Options.printOptionFooter();
    }
}
