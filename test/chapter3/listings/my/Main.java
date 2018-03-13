package chapter3.listings.my;

import common.Effect;
import common.Executable;
import common.Function;
import static common.CollectionUtilities.*;

import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        option1();
        option2();
        option3();
        option4();
        option5();
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

    Function<Executable, Function<Executable, Executable>> compose = new Function<Executable, Function<Executable, Executable>>() {
        @Override
        public Function<Executable, Executable> apply(Executable arg) {
            return new Function<Executable, Executable>() {
                @Override
                public Executable apply(Executable arg1) {
                    arg.exec();
                    arg1.exec();
                };
            };
        }
    };
//            x -> y -> () -> {
//                x.exec();
//                y.exec();
//    };

    static void option6(){

        Function<Double, Double> addTax = x -> x * 1.09;
        Function<Double, Double> addShipping = x -> x + 3.5;
        List<Double> prices = list(10.10, 23.45, 32.07, 9.23);
        List<Double> newPrices = map(prices, addTax.andThen(addShipping));
        forEach(newPrices, printWith2Decimals);
    }
}
