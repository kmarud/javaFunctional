package chapter2.exercises.e2_5;

import common.Function;

public class Exercise2_5 {
    static Function<Integer, Integer> triple = arg -> arg * 3;

    static Function<Integer, Integer> square = arg -> arg * arg;

   static <T, U, V>  Function<Function<U, V>, Function<Function<T,U>, Function<T, V>>> higherCompose() {
       return  f -> g -> x -> f.apply(g.apply(x));
   }
}
