package lesson22.threads.p5.callable;

public class PriceResult {

    private final String source;
    private final int price;

    public PriceResult(String source, int price) {
        this.source = source;
        this.price = price;
    }

    public String getSource() {
        return source;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return source + " -> " + price;
    }
}