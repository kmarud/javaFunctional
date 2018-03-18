package chapter4.exercises.e4_4;

import chapter4.listings.l4_1.TailCall;

import java.util.List;

import static chapter4.listings.l4_1.TailCall.ret;
import static chapter4.listings.l4_1.TailCall.sus;
import static common.CollectionUtilities.append;
import static common.CollectionUtilities.list;

public class Exercise4_4 {

    private static TailCall<List<Integer>> range_(List<Integer> acc, Integer start, Integer end) {
        return end <= start
                ? ret(acc)
                : sus(() -> range_(append(acc, start), start + 1, end));
    }

    public static List<Integer> range(Integer start, Integer end) {
        return range_(list(), start, end).eval();
    }
}
