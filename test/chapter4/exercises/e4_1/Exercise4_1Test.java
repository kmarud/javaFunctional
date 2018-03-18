package chapter4.exercises.e4_1;

import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise4_1Test {

    @Test
    public void fib() {
        int n=10000;
        for (int i = 0; i <= n; i++) {
            System.out.println(Exercise4_1.fib(i) + " ");
        }
    }
}