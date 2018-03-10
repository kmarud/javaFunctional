package common;

import org.junit.Before;
import org.junit.Test;

import java.util.function.IntUnaryOperator;

import static org.junit.Assert.*;

public class FunctionTest {
    final Function<Integer, Integer> triple = x -> x * 3;
    final Function<Integer, Integer> square = x -> x * x;

    Integer squaredAndThenTrippled(int arg){
        return (arg * arg) * 3;
    }

    Integer tripledAndThenSquared(int arg){
        return (arg * 3) * (arg * 3);
    }

    @Before
    public void prepare(){


    }
    @Test
    public void composeOneParameterTest() {
        Integer value = triple.compose(square).apply(3);
        assertEquals(squaredAndThenTrippled(3), value);
    }
    @Test
    public void composeOneParameterTest2() {
        Function<Integer, Integer> f = triple.compose(square);
        assertEquals(squaredAndThenTrippled(3), f.apply(3));
    }

    @Test
    public void andThenOneParameterTest() {
        Integer value = triple.andThen(square).apply(3);
        assertEquals(tripledAndThenSquared(3), value);
    }

    @Test
    public void andThenOneParameterTest2() {
        Function<Integer, Integer> tripleAndCompose = triple.andThen(square);
        assertEquals(tripledAndThenSquared(3), tripleAndCompose.apply(3));
    }

    @Test
    public void identity() {
        Function<Integer,Integer> as = Function.identity();
        assertEquals(Integer.valueOf(4), as.apply(4));
        assertEquals(Integer.valueOf(46), as.apply(46));
    }

    @Test
    public void composeTwoParametersTest1() {
        Integer x = Function.compose(triple,square).apply(3);
        assertEquals(squaredAndThenTrippled(3), x);
        Integer y = Function.compose(square, triple).apply(3);
        assertEquals(tripledAndThenSquared(3), y);
    }

    @Test
    public void composeTwoParametersTest2() {
        Function<Integer, Integer> x = Function.compose(triple,square);
        assertEquals(squaredAndThenTrippled(3), x.apply(3));
        Function<Integer, Integer> y = Function.compose(square, triple);
        assertEquals(tripledAndThenSquared(3), y.apply(3));
    }

    @Test
    public void andThenTwoParametersTest1() {
        Integer x = Function.andThen(triple,square).apply(3);
        assertEquals(tripledAndThenSquared(3), x);
        Integer y = Function.andThen(square, triple).apply(3);
        assertEquals(squaredAndThenTrippled(3), y);
    }

    @Test
    public void andThenTwoParametersTest2() {
        Function<Integer, Integer> x = Function.andThen(triple,square);
        assertEquals(tripledAndThenSquared(3), x.apply(3));
        Function<Integer, Integer> y = Function.andThen(square, triple);
        assertEquals(squaredAndThenTrippled(3), y.apply(3));
    }

    @Test
    public void composeNoParameterTest1() {
        Function<Function<Integer, Integer>,
                Function<Function<Integer, Integer>,
                        Function<Integer, Integer>>> f = Function.compose();

        Integer g = f.apply(triple).apply(square).apply(3);
        assertEquals(tripledAndThenSquared(3), g);
    }

    @Test
    public void composeNoParameterTest2() {
        Function<Function<Integer, Integer>,
                Function<Function<Integer, Integer>,
                        Function<Integer, Integer>>> f = Function.compose();

        Function<Integer, Integer> g= f.apply(triple).apply(square);
        assertEquals(tripledAndThenSquared(3), g.apply(3));
    }

    @Test
    public void andThenNoParameterTest1(){
        Function<Function<Integer, Integer>,
                Function<Function<Integer, Integer>,
                        Function<Integer, Integer>>> f = Function.andThen();

        Integer g = f.apply(triple).apply(square).apply(3);
        assertEquals(squaredAndThenTrippled(3), g);
    }

    @Test
    public void andThenNoParameterTest2(){
        Function<Function<Integer, Integer>,
                Function<Function<Integer, Integer>,
                        Function<Integer, Integer>>> f = Function.andThen();

       Function<Integer, Integer> g = f.apply(triple).apply(square);
        assertEquals(squaredAndThenTrippled(3), g.apply(3));
    }

    @Test
    public void higherAndThenTest1() {
        Function<Function<Integer, Integer>,
                Function<Function<Integer, Integer>,
                        Function<Integer, Integer>>> f = Function.higherAndThen();
        Integer g = f.apply(triple).apply(square).apply(3);
        assertEquals(tripledAndThenSquared(3), g );
    }

    @Test
    public void higherAndThenTest2() {
        Function<Function<Integer, Integer>,
                Function<Function<Integer, Integer>,
                        Function<Integer, Integer>>> f = Function.higherAndThen();

        Function<Function<Integer, Integer>, Function<Integer, Integer>> h = f.apply(triple);

        Function<Integer, Integer> g = f.apply(triple).apply(square);

        assertEquals(tripledAndThenSquared(3), g.apply(3) );
        assertEquals(tripledAndThenSquared(3), h.apply(square).apply(3));
    }

    @Test
    public void higherComposeTest1() {
        Function<Function<Integer, Integer>,
                Function<Function<Integer, Integer>,
                        Function<Integer, Integer>>> f = Function.higherCompose();
        Integer g = f.apply(triple).apply(square).apply(3);
        assertEquals(squaredAndThenTrippled(3), g );
    }

    @Test
    public void higherComposeTest2() {
        Function<Function<Integer, Integer>,
                Function<Function<Integer, Integer>,
                        Function<Integer, Integer>>> f = Function.higherCompose();

        Function<Function<Integer, Integer>, Function<Integer, Integer>> h = f.apply(triple);

        Function<Integer, Integer> g = f.apply(triple).apply(square);

        assertEquals(squaredAndThenTrippled(3), g.apply(3) );
        assertEquals(squaredAndThenTrippled(3), h.apply(square).apply(3));
    }
}