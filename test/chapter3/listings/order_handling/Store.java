package chapter3.listings.order_handling;

import java.util.List;

import static common.CollectionUtilities.foldLeft;
import static common.CollectionUtilities.list;

public class Store {

    public static void main(String[] args) {
        Product toothPaste = new Product(Price.price(3.5), Weight.weight(0.5));
        Product toothBrush = new Product(Price.price(9.5), Weight.weight(0.3));
        List<OrderLine> order = list(
                new OrderLine(toothPaste, 2),
                new OrderLine(toothBrush, 3)
        );

        Price price = foldLeft(order, Price.ZERO, Price.sum);
        Weight weight = foldLeft(order, Weight.ZERO, Weight.sum);

        System.out.println(String.format("Total price: %s", price));
        System.out.println(String.format("Total weight: %s", weight));
    }
}
