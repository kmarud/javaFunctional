package chapter2.exercises.e2_6;

import common.Function;

public class Exercise2_6 {

    static Function<Integer, Integer> triple = arg -> arg * 3;

    static Function<Integer, Integer> square = arg -> arg * arg;



    Function<Integer, Integer> g;
//    Function<U,V, Function<T,U, T,V>;
    static <T, U, V>  Function<Function<T,U>, Function<Function<U, V>, Function<T, V>>> higherAndThen() {
        return  f -> g -> x -> g.apply(f.apply(x));
    }
}
