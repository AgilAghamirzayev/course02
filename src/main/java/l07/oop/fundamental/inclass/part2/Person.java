package l07.oop.fundamental.inclass.part2;

public class Person {
    private String name;
    private int age;

    public void name(String ad) {
        if (ad == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        if (ad.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (ad.length() > 20) {
            throw new IllegalArgumentException("Name cannot be more than 20 characters");
        }

        if (!ad.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name can only contain letters");
        }

        if (ad.length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters long");
        }

        name = ad;
    }

    public void age(int yas) {
        if (yas < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        age = yas;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println();
    }

}
