package l10.abstraction.polymorphism.interfaces.part2;

public class Qaranqus extends Bird implements Flyable{
    public Qaranqus(String name) {
        super(name);
    }

    @Override
    public void walk() {
        System.out.println("Qaranqus is walking");
    }

    @Override
    public void fly() {
        System.out.println("Qaranqus is flying");
    }
}
