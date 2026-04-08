package l9.oop.inheritance.objectclass.inclass.thisandsuper.part2;

class Animal {

    String type;

    public Animal() {
        System.out.println("Animal: Default constructor");
    }

    public Animal(String type) {
        this.type = type;
        System.out.println("Animal: Parameterized constructor -> type = " + type);
    }
    
}