package chapter3.listings.order_handling;

import common.Function;

public class Price {
    public static final Price ZERO = new Price(0.0);
    public static Function<Price, Function<OrderLine, Price>> sum = x -> y -> x.add(y.getAmount());
    private final double value;

    private Price(double value) {
        this.value = value;
    }

    public static Price price(double value) {
        if (value <= 0)
            throw new IllegalArgumentException("Price must be bigger than 0!");
        else
            return new Price(value);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    private Price add(Price that) {
        return new Price(this.value + that.value);
    }

    public Price mult(int count) {
        return new Price(this.value * count);
    }
}
