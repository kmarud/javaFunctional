package chapter3.exercises.e3_2;

import common.Function;

import java.util.regex.Pattern;

import static chapter3.exercises.e3_2.Case.match;
import static chapter3.exercises.e3_2.Case.mcase;
import static chapter3.exercises.e3_2.Result.failure;
import static chapter3.exercises.e3_2.Result.success;

public class EmailValidator {

    static final Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    static Effect<String> success = s -> System.out.println("Sending verification mail to: " + s);

    static Effect<String> failure = s -> System.err.println("Error message: " + s);

    public static void main(String[] args) {
        emailChecker.apply("this.is@any.address").bind(success, failure);
        emailChecker.apply(null).bind(success, failure);
        emailChecker.apply("").bind(success, failure);
        emailChecker.apply("john.doe@mail.com").bind(success, failure);
    }

    static Function<String, Result<String>> emailChecker = s -> match(
            mcase(() -> success(s)),
            mcase(() -> s == null, () -> failure("Email address cannot be null")),
            mcase(() -> s.length() == 0, () -> failure("Emil address cannot be empty")),
            mcase(() -> !emailPattern.matcher(s).matches(), () -> failure("Email address " + s + " is invalid"))
    );
}
