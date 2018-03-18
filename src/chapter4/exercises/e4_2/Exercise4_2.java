package chapter4.exercises.e4_2;

import chapter4.listings.l4_1.TailCall;

import java.math.BigInteger;

import static chapter4.listings.l4_1.TailCall.ret;
import static chapter4.listings.l4_1.TailCall.sus;

public class Exercise4_2 {
    public static BigInteger fib(int x){
        return fib_(BigInteger.ONE, BigInteger.ZERO, BigInteger.valueOf(x)).eval();
    }

    private static TailCall<BigInteger> fib_(BigInteger acc1, BigInteger acc2, BigInteger x){
        if(x.equals(BigInteger.ZERO))
            return ret(BigInteger.ZERO);
        else if (x.equals(BigInteger.ONE))
            return ret(acc1.add(acc2));
        else{
            return sus(() -> fib_(acc2, acc1.add(acc2), x.subtract(BigInteger.ONE)));
        }
    }
}
