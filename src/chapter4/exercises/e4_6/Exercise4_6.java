package chapter4.exercises.e4_6;

import common.CollectionUtilities;
import common.Function;

import java.util.List;

public class Exercise4_6 {

    static <T>Function<T, T> composeAll(List<Function<T, T>> list){
        return CollectionUtilities.foldRight(list, Function.identity(), x -> y -> x.compose(y));
    }
}
