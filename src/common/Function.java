package common;

public interface Function<T, U> {
    U apply(T arg);

    static <T> Function<T, T> compose(final Function<T, T> f1, Function<T, T> f2) {
        return x -> f1.apply(f2.apply(x));
    }
}
