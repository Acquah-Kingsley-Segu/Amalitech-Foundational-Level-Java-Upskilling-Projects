package amalitech.screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalScreen implements ScreenAction{
    int principal=0;
    Scanner scanner=new Scanner(System.in);
    @Override
    public void askForContent() {
        System.out.println("\n****** Enter A Principal Value Between 1000 and 1000000");
        System.out.println("****** Principal:");
    }

    @Override
    public void takeContent() {
        do {
            try {
                principal = scanner.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println(exception.getMessage());
                break;
            }
        }while (validateContent(principal));
    }

    @Override
    public boolean validateContent(double content) {
        return (!(content > 1000) || !(content <= 1_000_000));
    }

    @Override
    public double manipulateContent() {
        return principal;
    }
}

