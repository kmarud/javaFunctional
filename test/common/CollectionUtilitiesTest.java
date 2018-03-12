package common;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
}