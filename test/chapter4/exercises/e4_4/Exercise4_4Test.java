package chapter4.exercises.e4_4;

import org.junit.Test;

import java.util.List;

import static common.CollectionUtilities.list;
import static org.junit.Assert.*;

public class Exercise4_4Test {

    @Test
    public void range_Test() {
        List<Integer> list = Exercise4_4.range(1, 5000);
        list.forEach(System.out::print);
    }
}