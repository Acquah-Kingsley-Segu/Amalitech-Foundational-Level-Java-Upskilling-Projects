package amalitech;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String decision = "";
        int number = 0;

        System.out.println(
                """
                ********** Welcome To The FizzBuzz Game **********
                    *********** Follow the prompt *************
                    1. Game is in a spiral so it goes on and on.
                    2. Enter a number at each loop and try guess what the result will be.
                    3. Enter (-1) To end game for a coffee break
                """
        );
        while (number != -1) {
            System.out.print(">>> Enter your number: ");

            try {
                number = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("***** Enter a whole number *****");
            }

            decision = FizzBuzz.engine(number);
            System.out.println(decision);
        }
        System.out.println("Awwww :( see you soon");
    }
}