package validators;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;




public class SnrValidator extends PnrValidator {
    @Override
    public boolean isDateValid(String number) {
        number = extractNumbersFromNumber(number);
        number = extractDateFromNumber(number);

        int day = Integer.parseInt(number.substring(4,6)) - 60;
        number = number.substring(0,4) + day;

        DateFormat sdf = new SimpleDateFormat("yyMMdd");
        sdf.setLenient(false);

        try {
            sdf.parse(number);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
