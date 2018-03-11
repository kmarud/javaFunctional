package chapter3.listings.l3_2;

import org.junit.Test;
import static org.junit.Assert.*;

public class EmailValidatorTest {

    @Test
    public void testEmailChecker(){
        EmailValidator emailValidator = new EmailValidator();

        assertTrue(emailValidator.emailChecker.apply("john.doe@test.pl"));
        assertFalse(emailValidator.emailChecker.apply("asdf"));
        assertTrue(emailValidator.emailChecker.apply("paul.smith@test.com"));
        assertFalse(emailValidator.emailChecker.apply("asdf.asdf"));
    }

}