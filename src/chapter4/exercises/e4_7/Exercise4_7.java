package chapter4.exercises.e4_7;

import common.Function;

import java.util.List;

import static common.CollectionUtilities.foldLeft;
import static common.CollectionUtilities.reverse;

public class Exercise4_7 {
    static <T> Function<T, T> composeAllViaFoldLeft(List<Function<T, T>> list) {
        return x -> foldLeft(reverse(list), x, a -> b -> b.apply(a));
    }
}
