package chapter3.listings.l3_5;

import chapter3.listings.l3_3.Result;
import common.Function;

import java.util.regex.Pattern;

public class EmailValidator {

    static final Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    static final Function<String, Result> emailChecker = s ->
            s == null
                    ? new Result.Failure("Email address cannot be null")
                    : s.length() == 0
                    ? new Result.Failure("Emil address cannot be empty")
                    : emailPattern.matcher(s).matches()
                    ? new Result.Success()
                    : new Result.Failure("Email address " + s + " is invalid");

    public static void main(String[] args) {
        validate("this.is@any.address").exec();
        validate(null).exec();
        validate("").exec();
        validate("john.doe@mail.com").exec();
    }

    private static void logError(String s) {
        System.err.println("Error message: " + s);
    }

    private static void sendVerificationMail(String s) {
        System.out.println("Sending verification mail to: " + s);
    }

    static Executable validate(String s) {
        Result result = emailChecker.apply(s);
        return (result instanceof Result.Success)
                ? () -> sendVerificationMail(s)
                : () -> logError(((Result.Failure) result).getErrorMessage());
    }
}
