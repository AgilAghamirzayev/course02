package l16.examandrecord;

public class RecordDemo03ConstructorsAndMethods {

    public record Money(String currency, long amountInCents) {
        public Money(String currency) {
            this(currency, 0L);
        }
    }

    public record Rectangle(double width, double height) {

        public double area() {
            return width * height;
        }

        public double perimeter(String name) {
            System.out.println("Rectangle perimeter: " + name);
            return 2 * (width + height);
        }

    }

    public static void main(String[] args) {
        Money m1 = new Money("AZN");
        Money m2 = new Money("USD", 1599);
        Rectangle r = new Rectangle(5, 3);

        System.out.println("Money default: " + m1);
        System.out.println("Money full: " + m2);
        System.out.println("Area: " + r.area());
    }
}

