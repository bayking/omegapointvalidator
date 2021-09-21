package validators;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PnrValidator {

    public boolean validityCheck(String number) {
        return isFormatValid(number)
                && isDateValid(number)
                && isLuhnsValid(number);
    }

    protected boolean isFormatValid(String number) {
        Pattern pattern;
        Matcher matcher;
        switch (number.length()) {
            case 10:
            case 11:
                pattern = Pattern.compile("^[0-9]{6}[-+ ]?[0-9]{4}$");
                matcher = pattern.matcher(number);
                return matcher.matches();
            case 12:
            case 13:
                pattern = Pattern.compile("^([1-2][0-9])?[0-9]{6}[- ]?[0-9]{4}$");
                matcher = pattern.matcher(number);
                return matcher.matches();
            default:
                return false;
        }
    }

    protected boolean isDateValid(String number) {
        number = extractNumbersFromNumber(number);
        number = extractDateFromNumber(number);
        DateFormat sdf = new SimpleDateFormat("yyMMdd");
        sdf.setLenient(false);

        try {
            sdf.parse(number);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    protected boolean isLuhnsValid(String number) {
        int lastNum = Character.getNumericValue(number.charAt(number.length()-1));
        number = extractNumbersFromNumber(number);
        number = number.substring(number.length() - 10, number.length() - 1);

        int luhnsNum = 0;
        for (int i = 0; i < number.length(); i++) {
            int n = Character.getNumericValue(number.charAt(i));
            n = i % 2 == 0 ? n * 2 : n;
            luhnsNum += n > 9 ? n - 9 : n;
        }
        luhnsNum = (10 - (luhnsNum % 10)) % 10;
        return lastNum == luhnsNum;
    }


    protected String extractNumbersFromNumber(String number) {
        return number.replaceAll("[^0-9]", "");
    }

    protected String extractDateFromNumber(String number) {
        return number.substring(number.length() - 10, number.length() - 4);
    }
}
