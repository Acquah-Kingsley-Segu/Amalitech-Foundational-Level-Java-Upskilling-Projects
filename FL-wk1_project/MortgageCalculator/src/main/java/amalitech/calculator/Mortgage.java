package amalitech.calculator;

public class Mortgage {

    public double calculateMortgage(int principal, double monthlyInterest, int numberOfPayments){
        return principal*(monthlyInterest*Math.pow(1+monthlyInterest,numberOfPayments))/(Math.pow(1+monthlyInterest,numberOfPayments)-1);
    }
}
