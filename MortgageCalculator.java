import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {

        Scanner scan1 = new Scanner(System.in);
        System.out.print("Enter your home loan amount: ");
        int loanAmount = scan1.nextInt(); //loan amount

        System.out.print("Enter your interest rate: ");
        float originalRate = scan1.nextFloat();
        float monthlyInterestRate = (originalRate/100) / 12; //this is the formula to get a monthly rate


        System.out.print("How many years (period): ");
        int amountOfYears = scan1.nextInt();
        int numberOfMonths = amountOfYears * 12; //the 12 is the number of months in a year

        double interestPowerOfMonths = Math.pow(1 + monthlyInterestRate,numberOfMonths); //This multiplies the monthly interest rates to the power of number of months.

        double monthlyPayment = ((monthlyInterestRate * interestPowerOfMonths) / (interestPowerOfMonths - 1)) * loanAmount;
        // above is the actual formula to get a monthly mortgage payment.
        // in summary: principal * rate(1+rate)^years*30 divided by (1+rate)^years*30 minus one.
        // monthlyPayment = principal * (r(1+r)^n) / (((1+r)^n)-1)

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        String monthlyPaymentDollarSign = currencyInstance.format(monthlyPayment);


        System.out.println("Principal: "+loanAmount);
        System.out.println("Annual Interest Rate: "+originalRate);
        System.out.println("Period: "+amountOfYears);
        System.out.println("Mortgage: "+monthlyPaymentDollarSign);


    }
}
