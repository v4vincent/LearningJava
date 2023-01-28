import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {

        Scanner scan1 = new Scanner(System.in);
        System.out.print("Enter your home loan amount: ");
        int mortgage = scan1.nextInt();

        System.out.print("Enter your interest rate: ");
        float rate = scan1.nextFloat();
        float rate2 = (rate/100) / 12;
        float rate3 = rate2 + 1;

        System.out.print("How many years (period): ");
        int period = scan1.nextInt();
        int period2 = period * 12;

        double pow = Math.pow(rate3,period2);

        double monthlyPayment = ((rate2 * pow) / (pow - 1)) * mortgage;

        NumberFormat money = NumberFormat.getCurrencyInstance();
        String moneyString = money.format(monthlyPayment);


        System.out.println("Principal: "+mortgage);
        System.out.println("Annual Interest Rate: "+rate);
        System.out.println("Period: "+period);
        System.out.println("Mortgage: "+moneyString);


    }
}
