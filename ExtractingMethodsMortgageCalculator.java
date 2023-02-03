import java.text.NumberFormat;
import java.util.Scanner;

public class ExtractingMethodsMortgageCalculator {
    public static void main(String[] args) {
        int loanAmount = (int)readNumber("Principal: ", 1000,10_000_000);
        float originalRate = (float)readNumber("Interest rate: ",0.1,30);
        byte amountOfYears = (byte)readNumber("Years: ",0,30);

        double mortgage= calculatedMortgage(loanAmount, originalRate, amountOfYears);

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        String monthlyPaymentDollarSign = currencyInstance.format(mortgage);

        System.out.println("Principal: " + loanAmount);
        System.out.println("Annual Interest Rate: " + originalRate);
        System.out.println("Period: " + amountOfYears);
        System.out.println("Mortgage: " + monthlyPaymentDollarSign);
    }
    public static double readNumber(String prompt, double min, double max){
        Scanner scan1 = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scan1.nextFloat();
            if (value >= min && value <= max) {
                break;
            } else {
                System.out.println("Please enter a rate between " + min + " and " + max);
            }
        }
        return value;
    }
    public static double calculatedMortgage(
            int principal,
            float annualInterest,
            byte years){
        int numberOfMonths = years * 12;
        float monthlyInterestRate = (annualInterest / 100) / 12;

        double interestPowerOfMonths = Math.pow(1 + monthlyInterestRate, numberOfMonths);
        double monthlyPayment = ((monthlyInterestRate * interestPowerOfMonths) / (interestPowerOfMonths - 1)) * principal;
        return monthlyPayment;
    }

}
