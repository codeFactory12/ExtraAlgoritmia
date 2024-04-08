package com.FuzzyMatching.Menu;

import com.FuzzyMatching.Estructure.Serie;
import com.FuzzyMatching.Estructure.User;
import com.FuzzyMatching.UsersManager.UserFinder;

import java.util.ArrayList;
import java.util.Scanner;
public class Login {
    /**
     * Handles a user login by userId.
     *
     * @param seriesList the list of series
     * @param usersList the list of users
     */
    public static void login(ArrayList<Serie> seriesList, ArrayList<User> usersList ) {
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║             Login                    ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ Introduce your user Id:              ║");
            System.out.println("╚══════════════════════════════════════╝");

            System.out.print("User Id: ");
            String username = scanner.nextLine();

            if (username.equalsIgnoreCase("exit")) {
                System.out.println("\n╔═════════════════════════════════════════════════╗");
                System.out.println("║            Thank you for using our app!         ║");
                System.out.println("╚═════════════════════════════════════════════════╝");
                break;
            }
            User user = UserFinder.getInstance().findUser(username, usersList);

            if (usersList.contains(user)) {
                System.out.println("\n╔════════════════════════════════════╗");
                System.out.println("║        Login Successful!           ║");
                System.out.println("║ Welcome, " + username + "!");
                System.out.println("╚════════════════════════════════════╝");
                Options.MenuOptions(seriesList, usersList, user);
                break;
            } else {
                System.out.println("\n╔══════════════════════════════════════╗");
                System.out.println("║          Login Failed!               ║");
                System.out.println("║ Incorrect username. Please try again.║");
                System.out.println("╚══════════════════════════════════════╝");
            }
        } while (true);

        scanner.close();
    }
}
