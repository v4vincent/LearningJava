import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculatorWithErrorHandling {
    public static void main(String[] args) {

        Scanner scan1 = new Scanner(System.in);
        int loanAmount; //declare the initial variable outside the while, so it's scoped outside.
        while (true) { //infinite loop
            System.out.print("Enter your home loan amount: ");
            loanAmount = scan1.nextInt();
            if (loanAmount >= 1000 && loanAmount <= 10_000_000) {
                break;
            } else {
                System.out.println("Please enter an amount between $1k and $10m: ");
            }
        }

        float originalRate; //declare the initial variable outside the while, so it's scoped outside.
        while (true) { //infinite loop
            System.out.print("Enter your interest rate: ");
            originalRate = scan1.nextFloat();
            if (originalRate > 0 && originalRate <= 30) {
                break;
            } else {
                System.out.println("Please enter a rate between 1 and 30");
            }
        }
        float monthlyInterestRate = (originalRate / 100) / 12; //this is the formula to get a monthly rate

        int amountOfYears; //declare the initial variable outside the while, so it's scoped outside.
        while (true) { //infinite loop
            System.out.print("How many years (period): ");
            amountOfYears = scan1.nextInt();
            if (amountOfYears > 0 && amountOfYears <= 30) {
                break;
            } else {
                System.out.println("Please enter a number between 1 and 30: ");
            }
        }
        int numberOfMonths = amountOfYears * 12; //the 12 is the number of months in a year
        double interestPowerOfMonths = Math.pow(1 + monthlyInterestRate, numberOfMonths); //This multiplies the monthly interest rates to the power of number of months.

        double monthlyPayment = ((monthlyInterestRate * interestPowerOfMonths) / (interestPowerOfMonths - 1)) * loanAmount;
        // above is the actual formula to get a monthly mortgage payment.
        // in summary: principal * rate(1+rate)^years*30 divided by (1+rate)^years*30 minus one.
        // monthlyPayment = principal * (r(1+r)^n) / (((1+r)^n)-1)

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        String monthlyPaymentDollarSign = currencyInstance.format(monthlyPayment);


        System.out.println("Principal: " + loanAmount);
        System.out.println("Annual Interest Rate: " + originalRate);
        System.out.println("Period: " + amountOfYears);
        System.out.println("Mortgage: " + monthlyPaymentDollarSign);


    }



}


