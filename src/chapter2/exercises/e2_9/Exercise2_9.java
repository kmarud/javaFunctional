package chapter2.exercises.e2_9;

import common.Function;

public class Exercise2_9 {

    static <A, B, C, D> Function<A, Function<B, Function<C, Function<D, String>>>> func() {
        return a -> b -> c -> d -> String.format("%s, %s, %s, %s", a, b, c, d);
    }
}
