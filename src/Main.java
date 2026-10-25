import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double gross, pension,
                lower, higher,
                tier1, tier2, tier3,
                tier4, tier5, tier6,
                nationalInsurance, healthInsurance,
                fund ,incomeTax, income;
        Scanner input = new Scanner(System.in);

        System.out.print("Input the earnings:\n");
        gross = input.nextDouble();

        pension = gross * 0.06;

        lower = Math.min(gross, 7703);
        higher = Math.min(gross, 51910);

        nationalInsurance = lower * 0.0104 + (higher-lower) * 0.07;
        healthInsurance = lower * 0.0323 + (higher-lower) * 0.0517;

        fund = Math.min(gross * 0.025, 392.8);

        tier1 = Math.min(gross, 7010);
        tier2 = Math.min(gross, 10060);
        tier3 = Math.min(gross, 19000);
        tier4 = Math.min(gross, 25100);
        tier5 = Math.min(gross, 46690);
        tier6 = Math.min(gross, 60130);

        incomeTax = tier1 * 0.1 + Math.max(tier2 - tier1, 0) * 0.14 +
                Math.max(tier3 - tier2, 0) * 0.20 +
                Math.max(tier4 - tier3, 0) * 0.30 +
                Math.max(tier5 - tier4, 0) * 0.35 +
                Math.max(tier6 - tier5, 0) * 0.47 +
                Math.max(gross - tier6, 0) * 0.5;

        income = gross - pension - nationalInsurance - healthInsurance - fund - incomeTax;

        System.out.print("The pension tax is: " + pension +
                "\nThe national insurance tax is: " + nationalInsurance +
                "\nThe health insurance tax is: " + healthInsurance +
                "\nThe something something fund tax is: " + fund +
                "\nThe income tax is: " + incomeTax +
                "\nThe total income is: " + income);
    }
}