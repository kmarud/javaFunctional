package chapter3.exercises.e3_1;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmailValidatorTest {

    @Test
    public void testEmailChecker(){
        Result<String> r = EmailValidator.emailChecker.apply("john.doe@test.pl");
        assertTrue(r instanceof Result.Success);

        r = EmailValidator.emailChecker.apply("asdf");
        assertTrue(r instanceof Result.Failure);

        r = EmailValidator.emailChecker.apply("");
        assertTrue(r instanceof Result.Failure);

        r = EmailValidator.emailChecker.apply(null);
        assertTrue(r instanceof Result.Failure);

        r = EmailValidator.emailChecker.apply("paul.smith@test.com");
        assertTrue(r instanceof Result.Success);

        r = EmailValidator.emailChecker.apply("asdf.asdf");
        assertTrue(r instanceof Result.Failure);


//        assertTrue(emailValidator.emailChecker.apply("john.doe@test.pl"));
//        assertFalse(emailValidator.emailChecker.apply("asdf"));
//        assertTrue(emailValidator.emailChecker.apply("paul.smith@test.com"));
//        assertFalse(emailValidator.emailChecker.apply("asdf.asdf"));
    }

}