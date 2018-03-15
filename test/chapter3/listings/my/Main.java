package chapter3.listings.my;

import common.Effect;
import common.Executable;
import common.Function;
import static common.CollectionUtilities.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        option1();
//        option2();
//        option3();
//        option4();
//        option5();
//        option6();
//        option7();
//        option8();
        option9();
        option10();
    }

    static void option1(){
        Function<Double, Double> addTax = x -> x * 1.09;
        Function<Double, Double> addShipping = x -> x + 3.5;
        List<Double> prices = list(10.10, 23.45, 32.07, 9.23);
        List<Double> pricesIncludingTax = map(prices, addTax);
        List<Double> pricesIncludingShipping = map(pricesIncludingTax, addShipping);
        System.out.println(pricesIncludingShipping);
    }

    static void option2(){
        Function<Double, Double> addTax = x -> x * 1.09;
        Function<Double, Double> addShipping = x -> x + 3.5;
        List<Double> prices = list(10.10, 23.45, 32.07, 9.23);
        List<Double> newPrices = map(map(prices, addTax), addShipping);
        System.out.println(newPrices);
    }

    static void option3(){
        Function<Double, Double> addTax = x -> x * 1.09;
        Function<Double, Double> addShipping = x -> x + 3.5;
        List<Double> prices = list(10.10, 23.45, 32.07, 9.23);
        List<Double> newPrices = map(prices, addShipping.compose(addTax));
        System.out.println(newPrices);
    }

    static void option4(){
        Function<Double, Double> addTax = x -> x * 1.09;
        Function<Double, Double> addShipping = x -> x + 3.5;
        List<Double> prices = list(10.10, 23.45, 32.07, 9.23);
        List<Double> newPrices = map(prices, addTax.andThen(addShipping));
        System.out.println(newPrices);
    }

    static Effect<Double> printWith2Decimals = x -> {
        System.out.printf("%.2f", x);
        System.out.println();
    };


    public static <T> void forEach(Collection<T> ts, Effect<T> e){
        for (T t: ts) e.apply(t);
    }
    static void option5(){

        Function<Double, Double> addTax = x -> x * 1.09;
        Function<Double, Double> addShipping = x -> x + 3.5;
        List<Double> prices = list(10.10, 23.45, 32.07, 9.23);
        List<Double> newPrices = map(prices, addTax.andThen(addShipping));
        forEach(newPrices, printWith2Decimals);
    }

    static Function<Executable, Function<Executable, Executable>> compose = arg1 -> arg2 -> () -> {
        arg1.exec();
        arg2.exec();
    };


    static void option6(){
        Executable ez = () -> {};
        Function<Double, Double> addTax = x -> x * 1.09;
        Function<Double, Double> addShipping = x -> x + 3.5;
        List<Double> prices = list(10.10, 23.45, 32.07, 9.23);
        List<Double> pricesIncludingTax = map(prices, addTax);
        List<Double> pricesIncludingShipping = map(pricesIncludingTax, addShipping);
        Executable program = foldLeft(pricesIncludingShipping, ez, e -> d -> compose.apply(e).apply(() -> printWith2Decimals.apply(d)));
        program.exec();
    }

    static void option7(){
        Executable a = System.out::println;
        list(1,2,3,4).forEach(System.out::println);
    }

    static void option8(){
        range(0,5).forEach(System.out::println);
    }

    static void option9(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i*i);
        }
        System.out.println(list);
    }

    static void option10(){
//        List<Integer> list = mapViaFoldLeft(range(0,5), x -> x * x);
        List<Integer> list = map(range(0,5), x -> x * x);
        System.out.println(list);
    }
}
