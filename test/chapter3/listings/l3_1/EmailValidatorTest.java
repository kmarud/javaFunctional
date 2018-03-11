package chapter3.listings.l3_1;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmailValidatorTest {

    @Test
    public void testMail() {
        EmailValidator emailValidator = new EmailValidator();
        emailValidator.testMail("john.doe@testowe.pl");
        emailValidator.testMail("asd");
    }
}