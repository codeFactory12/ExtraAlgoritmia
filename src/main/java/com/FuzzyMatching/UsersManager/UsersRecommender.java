package com.FuzzyMatching.UsersManager;

import com.FuzzyMatching.Estructure.User;
import com.intuit.fuzzymatcher.component.MatchService;
import com.intuit.fuzzymatcher.domain.Document;
import com.intuit.fuzzymatcher.domain.Element;
import com.intuit.fuzzymatcher.domain.ElementType;
import com.intuit.fuzzymatcher.domain.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A class to recommend users
 */
public class UsersRecommender {
    private ArrayList<User> usersList;
    private UserFinder userFinder;
    private MatchService matchService;

    /**
     * Constructs a UsersRecommender with the given list of users.
     *
     * @param usersList the list of users
     */
    public UsersRecommender(ArrayList<User> usersList){
        this.usersList = usersList;
        userFinder = UserFinder.getInstance();
        matchService = new MatchService();
    }

    /**
     * Builds a Document of the fuzzy matcher library with liked genres and age
     * @param user the user to build the document with
     * @return the built document
     */
    private Document getDocumentFromUser(User user){
        return new Document.Builder(user.getId())
            .addElement(
                new Element.Builder<String[]>().setValue(
                        user.getlikedgenres()).setType(ElementType.WORDS).createElement())
            .addElement(
                    new Element.Builder<Integer>().setValue(
                            user.getAge()).setType(ElementType.AGE).createElement())
            .createDocument();
    }

    /**
     * Recommends users similar to the given user based on liked genres and age.
     *
     * @param user the user profile to find recommendations for
     */
    public void recommendUsers(User user){
        Document userDocument = getDocumentFromUser(user);
        List<Document> documentList = usersList.stream().map(u -> getDocumentFromUser(u))
                .collect(Collectors.toList());

        Map<String, List<Match<Document>>> result = matchService.applyMatchByDocId(userDocument, documentList);
        result.forEach((key, value) -> value.sort((m1, m2) ->
            Double.compare(m2.getScore().getResult(), m1.getScore().getResult())));

        result.entrySet().forEach(entry -> entry.getValue().stream()
            .filter(match -> !match.getMatchedWith().getKey().equals(user.getId()))
            .limit(5)
            .forEach(match -> {
                System.out.println("\nSCORE MATCH: " + Math.round(match.getScore().getResult() * 100) + "%");
                System.out.println(userFinder.findUser(match.getMatchedWith().getKey(), usersList));
            }));
    }
}
