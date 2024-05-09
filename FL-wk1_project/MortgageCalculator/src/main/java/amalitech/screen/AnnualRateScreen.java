package amalitech.screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AnnualRateScreen implements ScreenAction{

    final byte PERCENT=100;
    float annualInterestRate;
    Scanner scanner=new Scanner(System.in);

    @Override
    public void askForContent() {
        System.out.println("\n****** Enter Annual Interest Rate ******");
    }

    @Override
    public void takeContent() {
        do {
            System.out.println("***** Enter Rate: ");
            try {
                annualInterestRate = scanner.nextFloat();
            } catch (InputMismatchException exception) {
                System.out.println(exception.getMessage());
                break;
            }
        } while (validateContent(annualInterestRate));
    }

    @Override
    public boolean validateContent(double content) {
      return (!(content >= 0) || !(content <= 100));
    }

    public double manipulateContent(){
        return annualInterestRate/PERCENT/MONTHS_IN_YEAR;
    }
}
