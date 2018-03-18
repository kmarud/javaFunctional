package chapter4.listings.l4_2;

import chapter4.listings.l4_1.TailCall;

import static chapter4.listings.l4_1.TailCall.Return.*;

public class Add {
    public static void main(String[] args) {
        new Add().run();
    }

    private void run(){
        System.out.println(add(6,6).eval());
    }

    private static TailCall<Integer> add(int x, int y){
        return y == 0
                ? ret(x)
                : sus(() -> add(x +1, y -1));
    }
}
