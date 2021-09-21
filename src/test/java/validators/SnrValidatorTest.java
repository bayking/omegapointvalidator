package validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SnrValidatorTest {

    SnrValidator snrValidator = new SnrValidator();
    List<String> validNumbers = List.of("190910799824");

    @Test
    void validityCheckValidNumbers() {
        for (String num : validNumbers) {
            Assertions.assertEquals(true, snrValidator.validityCheck(num));
        }
    }
}