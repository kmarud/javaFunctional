package chapter4.exercises.e4_5;

import chapter4.listings.l4_1.TailCall;
import common.Function;

import java.util.List;

import static common.CollectionUtilities.head;
import static common.CollectionUtilities.reverse;
import static common.CollectionUtilities.tail;

public class Exercise4_5 {

    public static <T,U> U foldRight(List<T> ts, U identity, Function<T, Function<U,U>>f){
        return foldRight_(identity, reverse(ts), f).eval();
    }
    private static <T,U> TailCall<U> foldRight_(U acc, List<T> ts, Function<T, Function<U, U>> f){
        return ts.isEmpty()
                ? TailCall.ret(acc)
                : TailCall.sus(() -> foldRight_(f.apply(head(ts)).apply(acc), tail(ts), f));
    }
}
