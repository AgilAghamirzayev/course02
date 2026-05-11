package l14.colelctions.inclass.s6;

public class ProductService {

    public void reserve(String sku, int requestedQty, int stockQty) {
        if (requestedQty <= 0) {
            throw new IllegalArgumentException("requestedQty musbet olmalidir");
        }
        if (requestedQty > stockQty) {
            throw new InsufficientStockException("Stok catmir. SKU=" + sku + ", requested=" + requestedQty + ", stock=" + stockQty);
        }
        System.out.println("Reserved: " + requestedQty);
    }

    public static void main(String[] args) {
        ProductService ps  = new ProductService();
//        ps.reserve("apple", 10, 15);
        ps.reserve("apple", 10, 5);
    }

}