package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int randomNumber;
        final int possibleNumberOfGuesses = 5;
        int[] userGuesses = new int[5];
        String endKeyStroke = "";
        Scanner input = new Scanner(System.in);
        int userGuess;


        String welcomePrompt = """
                ************** Welcome to GuessIT Game **************
                **     Your task is to guess the right number.     **
                **     The number is between 1 - 10 inclusive.     **
                **     You have five(5) trials to guess right.     **
                **             Enter "q" to end game.              **
                **         Good luck, we cheering you on :)        **
                *****************************************************
                """;
        System.out.println(welcomePrompt);

        do {
            randomNumber = (int) ((Math.random()) * 10);
            System.out.println("Number to guess is generated.");
            for (int counter = 1; counter <= possibleNumberOfGuesses; counter++){
                System.out.print("Enter your guess number: ");
                userGuess = input.nextInt();
                userGuesses[counter - 1] = userGuess;
                input.nextLine();
                if (userGuess == randomNumber)
                {
                    System.out.println("You guessed right.");
                    break;
                }
                System.out.println("Wrong guess.\nYou have (" + (possibleNumberOfGuesses - counter) + ") more guesses.");
            }
            System.out.println("Your guessed numbers are " + Arrays.toString(userGuesses));
            System.out.print("Enter 'c' to continue or 'q' to exit: ");
            endKeyStroke = input.nextLine();
        }while (!endKeyStroke.equals("q"));

        System.out.println("\n\n ******** END OF GAME ********");
    }
}