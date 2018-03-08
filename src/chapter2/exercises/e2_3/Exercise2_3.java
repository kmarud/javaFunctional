package chapter2.exercises.e2_3;

import common.Function;

public class Exercise2_3 {
    static Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;
}
