package l10.abstraction.polymorphism.interfaces.part2;

public class Test {

    public static void main(String[] args) {
        Bird b1 = new Penguien("Penguien 1");
        Bird b2 = new Serce("S1");
        Bird b3 = new Qaranqus("Q1");
        Bird b4 = new Penguien("P2");
        Bird b5 = new Qaranqus("Q2");
        Bird b6 = new Penguien("P3");

        Bird[] birds = {b1, b2, b3, b4, b5, b6};

        for (Bird bird : birds) {
            if (bird instanceof Flyable f) {
                System.out.println(">" + bird.getName() + "< can fly" );
//                f.fly();
            } else {
                System.out.println(">" + bird.getName() + "< cannot fly" );
            }
        }
    }

}
