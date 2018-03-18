package chapter4.exercises.e4_3;

import chapter4.listings.l4_1.TailCall;
import common.Function;

import java.util.List;

import static chapter4.listings.l4_1.TailCall.ret;
import static chapter4.listings.l4_1.TailCall.sus;
import static common.CollectionUtilities.head;
import static common.CollectionUtilities.tail;

public class Exercise4_3 {

    private static <T, U> U foldLeftSimple_(List<T> list, U identity, Function<U, Function<T, U>> f) {
        return list.isEmpty()
                ? identity
                : foldLeftSimple_(tail(list), f.apply(identity).apply(head(list)), f);
    }

    private static <T, U> TailCall<U> foldLeft_(List<T> list, U identity, Function<U, Function<T, U>> f) {
        return list.isEmpty()
                ? ret(identity)
                : sus(() -> foldLeft_(tail(list), f.apply(identity).apply(head(list)), f));
    }
}
