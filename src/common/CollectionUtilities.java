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

    public static Integer fold(List<Integer> list, Integer identity, Function<Integer,Function<Integer, Integer>> f){
        int result = identity;
        for (Integer i: list)
            result = f.apply(result).apply(i);
        return result;
    }

    public static<T, U> U foldLeft(List<T> list, U identity, Function<U,Function<T, U>> f){
        U result = identity;
        for (T i: list)
            result = f.apply(result).apply(i);
        return result;
    }

    public static<T, U> U foldRight(List<T> list, U identity, Function<T,Function<U, U>> f){
        U result = identity;
        for (int i= list.size() ; i > 0; i--)
            result = f.apply(list.get(i-1)).apply(result);
        return result;
    }

    public static<T, U> U foldRightRecursive(List<T> list, U identity, Function<T,Function<U, U>> f){
       return list.isEmpty()
               ? identity
               : f.apply(head(list)).apply(foldRightRecursive(tail(list), identity, f));
    }

    public static <T> List<T> prepend(List<T> list, T t){
        return foldLeft(list, list(t), x -> y -> append(x, y));
    }

    public static <T> List<T> reverse(List<T> list){
        return foldLeft(list, list(), x -> y -> prepend(x, y));
    }

    public static <T, U> List<U> mapViaFoldLeft(List<T> list, Function<T, U> f) {
        return foldLeft(list, list(), x -> y -> append(x, f.apply(y)));
    }

    public static <T, U> List<U> mapViaFoldRight(List<T> list, Function<T, U> f) {
        return foldRight(list, list(), x -> y -> prepend(y, f.apply(x)));
    }
}
