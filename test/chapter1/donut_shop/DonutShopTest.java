package chapter1.donut_shop;

import common.Tuple;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DonutShopTest {

    @Test
    public void buyDonut() {
        CreditCard creditCard = new CreditCard();
        Tuple<Donut, Payment> tuple = DonutShop.buyDonut(creditCard);
        assertEquals(tuple._2.creditCard, creditCard);
        assertEquals(tuple._2.amount, Donut.PRICE);
    }

    @Test
    public void buyDonuts(){
        CreditCard creditCard = new CreditCard();
        Tuple<List<Donut>, Payment> tuple = DonutShop.buyDonuts(5, creditCard);
        assertEquals(tuple._2.creditCard, creditCard);
        assertEquals(tuple._2.amount, Donut.PRICE * 5);

    }
}