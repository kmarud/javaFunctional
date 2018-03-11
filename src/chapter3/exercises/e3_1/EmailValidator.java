package chapter3.exercises.e3_1;


import common.Function;

import java.util.regex.Pattern;

public class EmailValidator {

    static final Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    static final Function<String, Result<String>> emailChecker = s -> {
        if (s == null)
            return Result.failure("Email address cannot be null");
        else if (s.length() == 0)
            return Result.failure("Emil address cannot be empty");
        else if (emailPattern.matcher(s).matches())
            return Result.success(s);
        else
            return Result.failure("Email address " + s + " is invalid");
    };
    static Effect<String> success = s -> System.out.println("Sending verification mail to: " + s);
    static Effect<String> failure = s -> System.err.println("Error message: " + s);

    public static void main(String[] args) {
        emailChecker.apply("this.is@any.address").bind(success, failure);
        emailChecker.apply(null).bind(success, failure);
        emailChecker.apply("").bind(success, failure);
        emailChecker.apply("john.doe@mail.com").bind(success, failure);
    }
}
