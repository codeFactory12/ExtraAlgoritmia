package com.FuzzyMatching.Menu.Commands;

import com.FuzzyMatching.Estructure.Serie;
import com.FuzzyMatching.Estructure.User;
import com.FuzzyMatching.Menu.Options;
import com.FuzzyMatching.SeriesManager.SeriesRecomender;

import java.util.ArrayList;
public class TopRecentsCommand implements Command {
    @Override
    public void execute(ArrayList<Serie> serieList, ArrayList<User> usersList, User user) {
        Options.printOptionHeader("Top Recents");
        SeriesRecomender seriesRecomender = new SeriesRecomender(serieList);
        seriesRecomender.recommendLastSeries();
        Options.printOptionFooter();
    }
}
