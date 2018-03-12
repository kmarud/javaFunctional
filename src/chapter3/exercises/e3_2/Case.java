package chapter3.exercises.e3_2;

import common.Supplier;
import common.Tuple;

public class Case<T> extends Tuple<Supplier<Boolean>, Supplier<Result<T>>>{

    private Case(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
        super(booleanSupplier, resultSupplier);
    }

    public static <T> Case<T> mcase(Supplier<Boolean> condition, Supplier<Result<T>> value) {
       return new Case<>(condition,value);
    }

    public static <T> DefaultCase<T> mcase(Supplier<Result<T>> value) {
        return new DefaultCase<>(() -> true, value);
    }

    public static <T> Result<T> match(DefaultCase<T> defaultCase, Case<T>... matchers) {
        for(Case<T> tCase: matchers){
            if(tCase._1.get())
                return tCase._2.get();
        }
        return defaultCase._2.get();
    }

    public static class DefaultCase<T> extends Case<T> {
        private DefaultCase(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
            super(booleanSupplier, resultSupplier);
        }
    }
}
