package l16.examandrecord;

import java.util.HashMap;
import java.util.Map;

public class RecordDemo05EqualsHashCodeMapKey {

    public record Point(int x, int y) {
    }

    public record ProductKey(String sku, String region) {
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        System.out.println("p1.equals(p2) = " + p1.equals(p2));

        Map<ProductKey, Integer> stock = new HashMap<>();
        stock.put(new ProductKey("SKU-1", "AZ"), 12);
        stock.put(new ProductKey("SKU-2", "AZ"), 4);

        Integer qty = stock.get(new ProductKey("SKU-1", "AZ"));
        System.out.println("Stock for SKU-1/AZ = " + qty);
    }
}

