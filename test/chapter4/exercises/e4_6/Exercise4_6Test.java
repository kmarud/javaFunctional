package chapter4.exercises.e4_6;

import common.Function;
import org.junit.Test;

import static chapter4.exercises.e4_6.Exercise4_6.composeAll;
import static org.junit.Assert.*;
import static common.CollectionUtilities.*;

public class Exercise4_6Test {

    @Test
    public void composeAllTest() {
        Function<Integer, Integer> add = x -> x+1;
        try {
            System.out.println(composeAll(map(range(0, 5000), x -> add)).apply(0));
        } catch (Exception e){

        }
    }
}