package chapter2.exercises.e2_2;

import common.Function;

public class Exercise2_2 {

    static Function<Integer, Integer> triple = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer arg) {
            return arg * 3;
        }
    };

    static Function<Integer, Integer> square = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer arg) {
            return arg * arg;
        }
    };

    <T> Function<T, T> compose(final Function<T, T> f1, Function<T, T> f2){
        return x -> f1.apply(f2.apply(x));
    }
}
