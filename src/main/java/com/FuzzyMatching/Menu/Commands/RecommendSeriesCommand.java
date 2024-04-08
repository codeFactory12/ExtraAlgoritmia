package com.FuzzyMatching.Menu.Commands;

import com.FuzzyMatching.Estructure.Serie;
import com.FuzzyMatching.Estructure.User;
import com.FuzzyMatching.Menu.Options;
import com.FuzzyMatching.RecomendSeriesByGenre.Recomend;

import java.util.ArrayList;

public class RecommendSeriesCommand implements Command {
    @Override
    public void execute(ArrayList<Serie> serieList, ArrayList<User> usersList, User user) {
        Options.printOptionHeader("Recomended Series");
        Recomend.RecomendationSeries(serieList, user);
        Options.printOptionFooter();
    }
}

