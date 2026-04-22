package l13.collections.usecases;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayListComparatorExample {
    public static void main(String[] args) {
        // Real use case: products can be sorted by different rules.
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Notebook", 4.2, 3.5));
        products.add(new Product("Pencil", 4.8, 1.0));
        products.add(new Product("Backpack", 4.5, 14.0));

        products.sort(Comparator.comparingDouble(p -> p.price));
        System.out.println("Comparator by price: " + products);

        products.sort(Comparator.comparingDouble((Product p) -> p.rating).reversed());
        System.out.println("Comparator by rating: " + products);
        System.out.println("Comparator: external flexible sorting rules.");
    }

    static class Product {
        String name;
        double rating;
        double price;

        Product(String name, double rating, double price) {
            this.name = name;
            this.rating = rating;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + "(rating=" + rating + ", price=" + price + ")";
        }
    }
}
