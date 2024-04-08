package com.FuzzyMatching.Menu;
import com.FuzzyMatching.Estructure.Serie;
import com.FuzzyMatching.Estructure.User;
import com.FuzzyMatching.Menu.Commands.*;
import com.FuzzyMatching.RecomendSeriesByGenre.Recomend;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Provides menu options and functionalities for users.
 */
public class Options {
    private static final String RESET = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";

    /**
     * Prints the header for a menu option.
     *
     * @param title the title of the menu option
     */
    public static void printOptionHeader(String title){
        System.out.println(YELLOW +
                "************************************************ " + title +
                " ************************************************" + RESET);
    }

    /**
     * Prints the footer for a menu option.
     */
    public static void printOptionFooter(){
        System.out.println(YELLOW +
                "***********************************************************************************" +
                "********************************" + RESET);
    }

    /**
     * Displays the main menu options for a logged user
     *
     * @param serieList the list of series
     * @param usersList the list of users
     * @param user the current user
     */
    public static void MenuOptions(ArrayList<Serie> serieList, ArrayList<User> usersList, User user) {
        Command[] commands = new Command[]{
                new RecommendUsersCommand(),
                new RecommendSeriesCommand(),
                new TopRecentsCommand(),
                new YourProfileCommand(),
                new TopBestRatingCommand(),
                new LogOutCommand()
        };
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("╔════════════════════════════════╗");
            System.out.println("║            Main Menu           ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Top 5 similar users         ║");
            System.out.println("║ 2. Recomended Series           ║");
            System.out.println("║ 3. Top Recents                 ║");
            System.out.println("║ 4. Your Profile                ║");
            System.out.println("║ 5. Top Best Rating             ║");
            System.out.println("║ 6. Log Out                     ║");
            System.out.println("║ 0. Exit                        ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Introduce an option: ");

            choice = scanner.nextInt();

            if (choice >= 1 && choice <= commands.length) {
                commands[choice - 1].execute(serieList, usersList, user);
            } else if (choice == 0) {
                System.out.println(RED + "EXIT" + RESET);
            } else {
                System.out.println(RED + "Invalid option. Please try again." + RESET);
            }
            System.out.println();

        } while (choice != 0);

        scanner.close();
    }
}