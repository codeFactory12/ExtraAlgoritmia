package com.FuzzyMatching.UsersManager;

import com.FuzzyMatching.Estructure.User;

import java.util.ArrayList;

/**
 * A class to find a user
 */
public class UserFinder {
    private static UserFinder instance;

    /**
     * Returns the singleton instance of UserFinder.
     *
     * @return the singleton instance of UserFinder
     */
    public static synchronized UserFinder getInstance() {
        if (instance == null) {
            instance = new UserFinder();
        }
        return instance;
    }

    /**
     * Finds a user by their ID in the provided list of users.
     *
     * @param id         the ID of the user to find
     * @param usersList  the list of users to search in
     * @return the User object if found, or null if not found
     */
    public User findUser(String id, ArrayList<User> usersList) {
        for (User user : usersList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
