package chapter3.listings.l3_4;

import chapter3.listings.l3_3.Result;
import common.Function;

import java.util.regex.Pattern;

public class EmailValidator {

    static final Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    static final Function<String, Result> emailChecker = s -> {
        if (s == null) {
            return new Result.Failure("Email address cannot be null");
        } else if (s.length() == 0) {
            return new Result.Failure("Emil address cannot be empty");
        } else if (emailPattern.matcher(s).matches()) {
            return new Result.Success();
        } else {
            return new Result.Failure("Email address " + s + " is invalid");
        }
    };

    public static void main(String[] args) {
        validate("this.is@any.address");
        validate(null);
        validate("");
        validate("john.doe@mail.com");
    }

    private static void logError(String s) {
        System.err.println("Error message: " + s);
    }

    private static void sendVerificationMail(String s) {
        System.out.println("Sending verification mail to: " + s);
    }

    static void validate(String s) {
        Result result = emailChecker.apply(s);
        if (result instanceof Result.Success) {
            sendVerificationMail(s);
        } else {
            logError(((Result.Failure) result).getErrorMessage());
        }
    }
}
