package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionUtilities {

    public static <T, U> List<U> map(List<T> list, Function<T, U> f) {
        List<U> newList = new ArrayList<>();
        for (T value : list)
            newList.add(f.apply(value));
        return newList;
    }

    public static <T> List <T> list(){
        return Collections.emptyList();
    }

    public static <T> List <T> list(T t){
        return Collections.singletonList(t);
    }

    public static <T> List <T> list(List<T> list){
        return Collections.unmodifiableList(new ArrayList<>(list));
    }

    @SafeVarargs
    public static <T> List <T> list(T... t){
//        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(t, t.length)));
        return List.of(Arrays.copyOf(t, t.length));
    }

    public static <T> T head(List<T> list) {
        if (list.isEmpty())
            throw new IllegalStateException("Head for empty list");
        return list.get(0);
    }

    private static <T> List<T> copy(List<T> list) {
        return new ArrayList<>(list);
    }

    public static <T> List<T> tail(List<T> list) {
        if(list.isEmpty())
            throw new IllegalStateException("Tail for empty list");
        List<T> workList = copy(list);
        workList.remove(0);
        return Collections.unmodifiableList(workList);
    }

    public static <T> List<T> append(List<T> list, T t){
        List<T> ts = copy(list);
        ts.add(t);
        return Collections.unmodifiableList(ts);
    }
}
