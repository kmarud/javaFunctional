package chapter4.exercises.e4_2;

import chapter4.exercises.e4_1.Exercise4_1;
import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise4_2Test {

    @Test
    public void fib() {
        int n=500;
        for (int i = 0; i <= n; i++) {
            System.out.println(Exercise4_1.fib(i) + " ");
        }
    }
}