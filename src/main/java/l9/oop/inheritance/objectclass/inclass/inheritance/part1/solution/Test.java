package l9.oop.inheritance.objectclass.inclass.inheritance.part1.solution;


public class Test {

    public static void main(String[] args) {
        Person john = new Person("John", 25);
        Programmer programmer = new Programmer("Ali", 22, "Google");
        programmer.learn();
        programmer.code();


//        john.code();

//        Dancer dancer = new Dancer("Aysun", 20, "DanceBand");
//        Singer singer = new Singer("Mary", 23, "SingerBand");
//
//        john.printDetails();
//        programmer.printDetails();
//        dancer.printDetails();
//        singer.printDetails();
//
//        startEating(john, programmer, dancer, singer);
//        startWalking(john, programmer, dancer, singer);
//
//        programmer.code();
//        dancer.dance();
//        singer.sing();
//        singer.playGuitar();

    }

    private static void startWalking(Person john, Programmer programmer, Dancer dancer, Singer singer) {
        john.walk();
        programmer.walk();
        dancer.walk();
        singer.walk();
    }

    private static void startEating(Person john, Programmer programmer, Dancer dancer, Singer singer) {
        john.eat();
        programmer.eat();
        dancer.eat();
        singer.eat();
    }

}
