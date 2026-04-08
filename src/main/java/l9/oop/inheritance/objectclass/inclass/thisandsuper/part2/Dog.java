package l9.oop.inheritance.objectclass.inclass.thisandsuper.part2;

class Dog extends Animal {

    String name;

    public Dog() {
        // implicitly calls super()
        System.out.println("Dog: Default constructor");
    }

    public Dog(String name) {
        this();
        this.name = name;
        System.out.println("Dog: Constructor with name -> " + name);
    }

    public Dog(String name, String type) {
        super(type);
        this.name = name;
        System.out.println("Dog: Constructor with name + type -> " + name + ", " + type);
    }

    public Dog(int age) {
        this("Buddy", "Mammal"); // calls Dog(String, String)
        System.out.println("Dog: Constructor with age -> " + age);
    }

}