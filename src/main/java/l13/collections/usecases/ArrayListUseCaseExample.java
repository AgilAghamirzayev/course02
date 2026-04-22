package l13.collections.usecases;

import java.util.ArrayList;

public class ArrayListUseCaseExample {
    public static void main(String[] args) {
        // Real use case: store shopping cart items.
        ArrayList<String> shoppingCart = new ArrayList<>();
        shoppingCart.add("Milk");
        shoppingCart.add("Bread");
        shoppingCart.add("Chocolate");

        shoppingCart.remove("Bread");

        System.out.println("Where to use ArrayList: frequent read by index and dynamic size.");
        System.out.println("Shopping cart: " + shoppingCart);
    }
}
