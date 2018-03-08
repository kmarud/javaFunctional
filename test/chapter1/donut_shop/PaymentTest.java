package chapter1.donut_shop;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentTest {

    @Test
    public void combine() {
        CreditCard creditCard = new CreditCard();
        Payment payment = new Payment(creditCard, 5);
        Payment newPayment = payment.combine(new Payment(creditCard, 4));
        assertEquals(9, newPayment.amount);
        assertEquals(creditCard, newPayment.creditCard);
    }

    @Test (expected = IllegalStateException.class)
    public void combineDifferentCards() {
        CreditCard creditCard1 = new CreditCard();
        CreditCard creditCard2 = new CreditCard();
        Payment payment = new Payment(creditCard1, 5);
        payment.combine(new Payment(creditCard2, 4));
    }
}