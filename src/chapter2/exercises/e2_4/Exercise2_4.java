package chapter2.exercises.e2_4;

import common.Function;

public class Exercise2_4 {

    static Function<Integer, Integer> triple = arg -> arg * 3;

    static Function<Integer, Integer> square = arg -> arg * arg;

    static Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>>> compose = x -> y -> z-> x.apply(y.apply(z));
}
