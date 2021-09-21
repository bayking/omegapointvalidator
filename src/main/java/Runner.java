
import validators.OnrValidator;
import validators.PnrValidator;
import validators.SnrValidator;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PnrValidator pnrValidator = new PnrValidator();
        OnrValidator onrValidator = new OnrValidator();
        SnrValidator snrValidator = new SnrValidator();

        String next = "";
        while (next != "end") {
            next = scanner.nextLine();
            if (pnrValidator.validityCheck(next))
                System.out.println(next + " är ett giltigt personnummer");
            else
                System.out.println(next + " är ett ogilitgt personnummer");

            if (onrValidator.validityCheck(next))
                System.out.println(next + " är ett giltigt organisationsnummer");
            else
                System.out.println(next + " är ett ogilitgt organisationsnummer");

            if (snrValidator.validityCheck(next))
                System.out.println(next + " är ett giltigt samordningsnummer");
            else
                System.out.println(next + " är ett ogilitgt samordningsnummer");
        }
    }
}
