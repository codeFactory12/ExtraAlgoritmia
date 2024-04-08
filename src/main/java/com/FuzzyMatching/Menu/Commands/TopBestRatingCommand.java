package com.FuzzyMatching.Menu.Commands;

import com.FuzzyMatching.Estructure.Serie;
import com.FuzzyMatching.Estructure.User;
import com.FuzzyMatching.Menu.Options;
import com.FuzzyMatching.RecomendedSeriesByRating.RecommendedSeriesByRating;

import java.util.ArrayList;

public class TopBestRatingCommand implements Command{
    @Override
    public void execute(ArrayList<Serie> serieList, ArrayList<User> usersList, User user) {
        Options.printOptionHeader("Top Best Rating");
        RecommendedSeriesByRating seriesByRating = new RecommendedSeriesByRating(serieList);
        seriesByRating.recommendLastSeries();
        Options.printOptionFooter();
    }

}
