package l10.abstraction.polymorphism.interfaces.part2;

public abstract class Bird {

    private String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void walk();

}
