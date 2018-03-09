package chapter2.exercises.e2_11;

import common.Function;

public class Exercise2_11 {

    static Function<Double, Function<Double,Double>> addTax = x -> y-> x + x / 100 * y;

    static <T,U,V> Function<T, Function<U,V>> reverseArgs(Function<U, Function<T, V>> f){
        return x -> y -> f.apply(y).apply(x);
    }
}
