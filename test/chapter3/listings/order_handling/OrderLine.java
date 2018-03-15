package chapter3.listings.order_handling;

public class OrderLine {
    private Product product;
    private int count;

    OrderLine(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public Weight getWeight() {
        return this.product.getWeight().mult(this.count);
    }

    public Price getAmount() {
        return this.product.getPrice().mult(this.count);
    }
}
