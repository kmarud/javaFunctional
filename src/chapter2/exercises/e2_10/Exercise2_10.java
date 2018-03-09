package chapter2.exercises.e2_10;

import common.Function;
import common.Tuple;

public class Exercise2_10 {
    //Tuple<A, B> na C

    static <A, B, C> Function<A, Function<B,C>> curry(Function<Tuple<A,B>, C> f){
        return new Function<A, Function<B, C>>() {
            @Override
            public Function<B, C> apply(A arg1) {
                return new Function<B, C>() {
                    @Override
                    public C apply(B arg2) {
                        return f.apply(new Tuple<>(arg1, arg2));
                    }
                };
            }
        };
    }
}
