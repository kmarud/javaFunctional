package chapter2.exercises.e2_8;

import common.Function;

public class Exercise2_8 {

    static <A,B,C> Function<A,C> partialB(B b, Function<A, Function<B, C >>f){
        return a -> f.apply(a).apply(b);
    }
}
