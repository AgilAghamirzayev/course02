package l10.abstraction.polymorphism.interfaces.part2;

public class Penguien extends Bird {

    public Penguien(String name) {
        super(name);
    }

    @Override
    public void walk() {
        System.out.println("Penguien is walking");
    }
}
