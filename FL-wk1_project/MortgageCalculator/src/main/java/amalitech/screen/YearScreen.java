package amalitech.screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class YearScreen implements ScreenAction{
    Scanner scanner=new Scanner(System.in);
    byte years;
    @Override
    public void askForContent() {
        System.out.println("\n***** Enter the period the mortgage will last *****");
    }

    @Override
    public void takeContent() {
        do {
            System.out.println("***** Period(Years): ");
            try {
                years = scanner.nextByte();
            }catch (InputMismatchException exception){
                System.out.println(">>>>> Enter a whole number <<<<<");
            }
        } while (!validateContent(years));
    }

    @Override
    public boolean validateContent(double content) {
        return (content > 0);
    }

    public double manipulateContent(){
        return years*MONTHS_IN_YEAR;
    }
}
