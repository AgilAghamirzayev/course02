package l10.abstraction.polymorphism.interfaces.part2;

public class Serce extends Bird implements Flyable{
    public Serce(String name) {
        super(name);
    }

    @Override
    public void walk() {
        System.out.println("Serce is walking");
    }

    @Override
    public void fly() {
        System.out.println("Serce is flying");
    }
}
