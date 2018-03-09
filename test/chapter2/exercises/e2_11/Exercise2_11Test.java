package chapter2.exercises.e2_11;

import common.Function;
import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise2_11Test {

    @Test
    public void addTaxTest(){
        Function<Double, Function<Double,Double>> reverseArgs = Exercise2_11.reverseArgs(Exercise2_11.addTax);
        Function<Double, Double> add9PercendTax = reverseArgs.apply(9.0);
        assertEquals( 10.9, add9PercendTax.apply(10.0), 0.001);

    }
}