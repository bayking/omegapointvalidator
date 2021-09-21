import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import validators.PnrValidator;

import java.util.List;

class PnrValidatorTest {

    PnrValidator pnrValidator = new PnrValidator();
    List<String> validNumbers = List.of("198112189876",
            "141206-2380",
            "20080903-2386",
            "7101169295",
            "198107249289",
            "19021214-9819",
            "190910199827",
            "191006089807",
            "192109099180",
            "4607137454",
            "194510168885",
            "900118+9811",
            "189102279800",
            "189912299816");
    List<String> invalidNumbers = List.of("999999999",
            "A41206-2380",
            "710116x9295",
            "19810724+9289",
            "190302299813",
            "201701272394"
    );

    @Test
    void validityCheckValidNumbers() {
        for (String num : validNumbers) {
            Assertions.assertTrue(pnrValidator.validityCheck(num));
        }
    }

    @Test
    void validityCheckInvalidNumbers() {
        for (String num : invalidNumbers) {
            Assertions.assertFalse(pnrValidator.validityCheck(num));
        }
    }
}