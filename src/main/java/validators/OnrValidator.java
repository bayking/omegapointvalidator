package validators;

public class OnrValidator extends PnrValidator {
    @Override
    public boolean isDateValid(String number) {
        number = extractNumbersFromNumber(number);
        String date = extractDateFromNumber(number);
        if ((number.length() == 12 && Integer.parseInt(number.substring(0, 2)) != 16)
                || Integer.parseInt(date.substring(2,4)) < 20) {
            return false;
        }
        return true;
    }
}
