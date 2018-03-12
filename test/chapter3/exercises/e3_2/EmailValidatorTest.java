package chapter3.exercises.e3_2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailValidatorTest {

    private boolean success = false;
    private boolean failure = false;

    private void setSuccess(boolean value) {
        success = value;
    }

    private void setFailure(boolean value) {
        failure = value;
    }

    @Before
    public void beforeEach() {
        setSuccess(false);
        setFailure(false);
    }

    @Test
    public void testEmailChecker() {
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
    }


    @Test
    public void testEmailCheckerValidMail() {
        Result<String> r = EmailValidator.emailChecker.apply("john.doe@test.pl");
        r.bind(s -> setSuccess(true), s -> setFailure(true));

        assertTrue(success);
        assertFalse(failure);
    }

    @Test
    public void testEmailCheckerNullMail() {
        Result<String> r = EmailValidator.emailChecker.apply(null);
        r.bind(s -> setSuccess(true), s -> setFailure(true));

        assertTrue(failure);
        assertFalse(success);
    }

    @Test
    public void testEmailCheckerEmptyMail() {
        Result<String> r = EmailValidator.emailChecker.apply("");
        r.bind(s -> setSuccess(true), s -> setFailure(true));

        assertTrue(failure);
        assertFalse(success);
    }

    @Test
    public void testEmailCheckerInvalidMail() {
        Result<String> r = EmailValidator.emailChecker.apply("abc.abd@abcd");
        r.bind(s -> setSuccess(true), s -> setFailure(true));

        assertTrue(failure);
        assertFalse(success);
    }

}