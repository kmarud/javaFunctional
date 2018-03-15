package common;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static common.CollectionUtilities.*;

public class CollectionUtilitiesTest {

    @Test
    public void mapTest() {
        Function<Integer, Double> f = x -> x * 1.5;

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Double> newList = CollectionUtilities.map(list, f);

        for (int i = 0; i < newList.size(); i++) {
            assertEquals(newList.get(i), f.apply(list.get(i)), 0.001);
        }
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testListNoArgsExceptionCheck(){
        List<Integer> list = CollectionUtilities.list();
        list.add(4);
    }

    @Test
    public void testListNoArgsSize(){
        List<Integer> list = CollectionUtilities.list();
        assertEquals(0, list.size());
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testListOneArgExceptionCheck(){
        List<Integer> list = CollectionUtilities.list(5);
        list.add(4);
    }

    @Test
    public void testListOneArgSize(){
        List<Integer> list = CollectionUtilities.list(5);
        assertEquals(1, list.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testListListArgExceptionCheck(){
        List<Integer> list = CollectionUtilities.list(Arrays.asList(1,2,3,4));
        list.add(5);
    }

    @Test
    public void testListListArgSize(){
        List<Integer> list = CollectionUtilities.list(Arrays.asList(1,2,3,4));
        assertEquals(4, list.size());
    }

    @Test
    public void testListListArgIsUnchangeable(){
        List<Integer> x = Arrays.asList(1,2,3,4);
        List<Integer> list = CollectionUtilities.list(x);
        x.set(0, 99);
        assertEquals(Integer.valueOf(1), list.get(0));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testListManyArgsExceptionCheck(){
        List<Integer> list = CollectionUtilities.list(1,2,3,4);
        list.add(5);
    }

    @Test
    public void testListManyArgsSize(){
        List<Integer> list = CollectionUtilities.list(1,2,3,4);
        assertEquals(4, list.size());
    }

    @Test
    public void testListManyArgsIsUnchangeable(){
        Integer[] tab = new Integer[]{1,2,3,4};
        List<Integer> list = CollectionUtilities.list(tab);
        tab[0] = 99;
        assertEquals(Integer.valueOf(1), list.get(0));
    }


    @Test
    public void testHead(){
        List<Integer> list = CollectionUtilities.list(1,2,3,4);
        assertEquals(Integer.valueOf(1), CollectionUtilities.head(list));
    }

    @Test
    public void testTail(){
        List<Integer> list = CollectionUtilities.list(1,2,3,4);
        List<Integer> workList = CollectionUtilities.tail(list);

        for (int i = 1; i < list.size(); i++) {
            assertEquals(list.get(i), workList.get(i-1));
        }
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testTailExceptionCheck(){
        List<Integer> list = CollectionUtilities.list(1,2,3,4);
        List<Integer> workList = CollectionUtilities.tail(list);

        workList.add(4);
    }

    @Test
    public void testTailIsUnchangeable(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<Integer> workList = CollectionUtilities.tail(list);
        list.set(1, 99);

        assertEquals(Integer.valueOf(2), workList.get(0));
    }

    @Test (expected = UnsupportedOperationException.class)
    public void tesAppendExceptionCheck(){
        List<Integer> list = CollectionUtilities.list(1,2,3,4);
        CollectionUtilities.append(list,5).add(5);
    }

    @Test
    public void testAppendCheckAddedValue(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<Integer> workList =  CollectionUtilities.append(list,5);

        assertEquals(Integer.valueOf(5), workList.get(4));
    }

    //fold

    @Test
    public void testFoldAdding(){
        List<Integer> list = list(1,2,3,4,5);
        Function<Integer, Function< Integer, Integer>> f = x -> y -> x + y;

        int value = CollectionUtilities.fold(list, 0, f);
        assertEquals(15, value);
    }

    @Test
    public void testFoldMultiply(){
        List<Integer> list = list(1,2,3,4,5);

        int value = CollectionUtilities.fold(list, 1, x -> y -> x * y);
        assertEquals(120, value);
    }

    // foldLeft

    @Test
    public void testFoldLeft(){
        List<Integer> list = list(1,2,3,4,5);
        String identity = "0";
        Function<String, Function< Integer, String>> f = x -> y -> addSI(x,y);

        String value = CollectionUtilities.foldLeft(list, identity, f);
        String expected = "(((((0 + 1) + 2) + 3) + 4) + 5)";
        assertEquals(expected, value);
    }

    private String addSI(String s, Integer i){
        return "(" + s + " + " + i + ")";
    }

    private String addSI(Integer i, String s){
        return "(" + i + " + " + s + ")";
    }

    @Test
    public void testFoldRight(){
        List<Integer> list = list(1,2,3,4,5);
        String identity = "0";
        Function<Integer, Function<String, String>> f = x -> y -> addSI(x,y);

        String value = CollectionUtilities.foldRight(list, identity, f);
        String expected = "(1 + (2 + (3 + (4 + (5 + 0)))))";
        assertEquals(expected, value);
    }

    @Test
    public void testFoldRightRecursive(){
        List<Integer> list = list(1,2,3,4,5);
        String identity = "0";
        Function<Integer, Function<String, String>> f = x -> y -> addSI(x,y);

        String value = CollectionUtilities.foldRightRecursive(list, identity, f);
        String expected = "(1 + (2 + (3 + (4 + (5 + 0)))))";
        assertEquals(expected, value);
    }

    //******prepend

    @Test
    public void testPrepend(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<Integer> workList =  CollectionUtilities.prepend(list,5);

        assertEquals(Integer.valueOf(5), workList.get(0));
        assertEquals(Integer.valueOf(1), workList.get(1));
    }


    //********** reverse
    @Test
    public void testReverse(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<Integer> workList =  CollectionUtilities.reverse(list);

        assertEquals(Integer.valueOf(4), workList.get(0));
        assertEquals(Integer.valueOf(3), workList.get(1));
        assertEquals(Integer.valueOf(2), workList.get(2));
        assertEquals(Integer.valueOf(1), workList.get(3));
    }

    @Test
    public void mapViaFoldLeftTest() {
        Function<Integer, Double> f = x -> x * 1.5;

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Double> newList = CollectionUtilities.mapViaFoldLeft(list, f);

        for (int i = 0; i < newList.size(); i++) {
            assertEquals(newList.get(i), f.apply(list.get(i)), 0.001);
        }
    }

    @Test
    public void mapViaFoldRightTest() {
        Function<Integer, Double> f = x -> x * 1.5;

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Double> newList = CollectionUtilities.mapViaFoldRight(list, f);

        for (int i = 0; i < newList.size(); i++) {
            assertEquals(newList.get(i), f.apply(list.get(i)), 0.001);
        }
    }

    @Test
    public void testRange() {
        List<Integer> list = CollectionUtilities.range(1,5);
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
        assertEquals(Integer.valueOf(4), list.get(3));
    }

    @Test
    public void testUnfold() {
        List<Integer> list = CollectionUtilities.unfold(1,x -> x+1, x -> x < 5);
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
        assertEquals(Integer.valueOf(4), list.get(3));
    }

    @Test
    public void testRangeByUnfold() {
        List<Integer> list = CollectionUtilities.rangeByUnfold(1,5);
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
        assertEquals(Integer.valueOf(4), list.get(3));
    }

    @Test
    public void testRangeByPrepend() {
        List<Integer> list = CollectionUtilities.rangeByPrepend(1,5);
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
        assertEquals(Integer.valueOf(4), list.get(3));
    }
}