package chapter4.listings.l4_4;

import chapter4.listings.l4_1.TailCall;
import common.Function;

public class Add {
    public static void main(String[] args) {
        new Add().run();
    }

    private void run(){
        System.out.println(add.apply(3).apply(3));
    }

    static Function<Integer, Function<Integer, Integer>> add = x -> y -> {
        class AddHelper {
            Function<Integer, Function<Integer, TailCall<Integer>>> addHelper =
                    a -> b -> b == 0
                            ? TailCall.ret(a)
                            : TailCall.sus(() -> this.addHelper.apply(a + 1).apply(b - 1));
        }
            return new AddHelper().addHelper.apply(x).apply(y).eval();
        };
    }
//    private static TailCall<Integer> add(int x, int y){
//        return y == 0
//                ? ret(x)
//                : sus(() -> add(x +1, y -1));
//    }

