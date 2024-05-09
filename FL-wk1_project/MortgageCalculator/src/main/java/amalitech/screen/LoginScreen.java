package amalitech.screen;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

public class LoginScreen implements ScreenAction{

    Console console = System.console();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void askForContent() {
        System.out.println("******************** Log into the system ********************");
        System.out.print("****** Enter your username: ");
        String username = scanner.nextLine();

        System.err.print("****** Enter your password: ");
        String password = scanner.nextLine();

        System.out.println(username);
        System.out.println(password);
    }

    @Override
    public void takeContent() {

    }

    @Override
    public boolean validateContent(double content) {
        return false;
    }

    @Override
    public double manipulateContent() {
        return 0;
    }
}
