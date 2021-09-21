package validators;

import java.time.format.DateTimeFormatter;



public class SnrValidator extends PnrValidator {
    @Override
    public boolean isDateValid(String number) {
        number = extractNumbersFromNumber(number);
        number = extractDateFromNumber(number);

        int day = Integer.parseInt(number.substring(4,6)) - 60;
        number = number.substring(0,4) + day;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMdd");
        try {
            dtf.parse(number);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
