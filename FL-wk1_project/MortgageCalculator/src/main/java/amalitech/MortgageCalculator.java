package amalitech;

import amalitech.calculator.Mortgage;
import amalitech.screen.*;

import java.text.NumberFormat;

/**
 * Building A Mortgage Calculator
 * Requirement Specs:
 * 1. Principal:100000
 * 2.Annual Interest Rates:4.2
 * 3. Period(Years):30
 * 4. Mortgage:$?
 * 5.
 */
public class MortgageCalculator {
    public static void main(String[] args) {
        /**
         * TODO 1: Incorporate down payment
         * TODO 2: Country based mortgage calculation
         * TODO 3: Country taxes that affect mortgage
         * TODO 4: Home owners insurance
         * TODO 5: Private Mortgage Insurance (PMI)
         * TODO 6: Incorporate database to allow storage of multiple calculated mortgages
         * TODO 7: Calculate both monthly and entire period interest on mortgage
         * TODO 8: Total mortgage paid after of period
         * TODO 9: Implement it as web service, docker, jenkins, sonarqube and deploy
         * TODO : A Spring version of program once all add ons are done
         */



        ScreenAction screenType = new LoginScreen();
        Mortgage mortgageClass = new Mortgage();

        screenType.askForContent();

        screenType = new PrincipalScreen();

        System.out.println(
                """
                ********** Welcome To Kingsley's Mortgage Calculator **********
                          *********** Follow the prompt *************
                """
        );
        screenType.askForContent();
        screenType.takeContent();
        int principal = (int) screenType.manipulateContent();

        screenType = new AnnualRateScreen();
        screenType.askForContent();
        screenType.takeContent();
        double monthlyInterest = screenType.manipulateContent();

        screenType = new YearScreen();
        screenType.askForContent();
        screenType.takeContent();
        int numberOfPayments = (int) screenType.manipulateContent();

        double mortgage = mortgageClass.calculateMortgage(principal, monthlyInterest, numberOfPayments);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.printf("->>>>> Mortgage payment per month : %s%n", mortgageFormatted);
    }
}