package chapter3.exercises.e3_1;

public interface Result<T> {

    static <T> Failure failure(String message) {
        return new Failure<T>(message);
    }

    static <T> Success success(T value) {
        return new Success<T>(value);
    }

    void bind(Effect<T> success, Effect<String> failure);

    class Success<T> implements Result<T> {

        private final T value;

        private Success(T t) {
            value = t;
        }

        @Override
        public void bind(Effect<T> success, Effect<String> failure) {
            success.apply(value);
        }
    }

    class Failure<T> implements Result<T> {

        private final String errorMessage;

        private Failure(String s) {
            this.errorMessage = s;
        }

        @Override
        public void bind(Effect<T> success, Effect<String> failure) {
            failure.apply(errorMessage);
        }
    }
}
