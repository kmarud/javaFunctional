package chapter1.donut_shop;

import common.Tuple;

import java.util.Collections;
import java.util.List;

public class DonutShop {
    public static Tuple<Donut, Payment> buyDonut(CreditCard creditCard){
        Donut donut = new Donut();
        Payment payment = new Payment(creditCard, Donut.PRICE);
        return new Tuple<>(donut, payment);
    }

    public static Tuple<List<Donut>, Payment> buyDonuts(final int quantity, final CreditCard creditCard){
        List<Donut> donuts = Collections.nCopies(quantity, new Donut());
        Payment payment = new Payment(creditCard, quantity * Donut.PRICE);
        return new Tuple<>(donuts, payment);
    }
}
