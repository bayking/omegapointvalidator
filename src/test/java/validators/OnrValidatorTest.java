package validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class OnrValidatorTest {

    OnrValidator onrValidator = new OnrValidator();

    List<String> validNumbers = List.of("556614-3185",
            "16556601-6399",
            "262000-1111",
            "857202-7566");

    @Test
    void validityCheckValidNumbers() {
        for (String num : validNumbers) {
            Assertions.assertEquals(true, onrValidator.validityCheck(num));
        }
    }
}