package chapter3.listings.order_handling;

public class Product {

    private final Price price;
    private final Weight weight;

    Product(Price price, Weight weight) {
        this.price = price;
        this.weight = weight;
    }

    public Price getPrice() {
        return price;
    }

    public Weight getWeight() {
        return weight;
    }

}
