package chapter4.exercises.e4_5;

import common.CollectionUtilities;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Exercise4_5Test {

    @Test
    public void foldRight() {
        Integer value = Exercise4_5.foldRight(CollectionUtilities.list(1,2,3,4, 5),0,  x -> y -> x + y);
        System.out.println(value);
    }
}