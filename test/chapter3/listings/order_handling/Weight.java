package chapter3.listings.order_handling;

import common.Function;

public class Weight {
    public static final Weight ZERO = new Weight(0.0);
    public static Function<Weight, Function<OrderLine, Weight>> sum = x -> y -> x.add(y.getWeight());
    private final double value;

    private Weight(double value) {
        this.value = value;
    }

    public static Weight weight(double value) {
        if (value <= 0)
            throw new IllegalArgumentException("Price must be bigger than 0!");
        else
            return new Weight(value);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    private Weight add(Weight that) {
        return new Weight(this.value + that.value);
    }

    public Weight mult(int count) {
        return new Weight(this.value * count);
    }
}
