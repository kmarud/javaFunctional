package chapter1.donut_shop;

public class Payment {
    public final CreditCard creditCard;
    public final int amount;

    public Payment(CreditCard creditCard, int amount) {
        this.creditCard = creditCard;
        this.amount = amount;
    }

    public Payment combine(Payment payment){
        if(this.creditCard.equals(payment.creditCard))
            return new Payment(creditCard, this.amount + payment.amount);
        else
            throw new IllegalStateException("Cards are different!");
    }
}
