package l16.examandrecord;

public class RecordDemo01Basic {

    public record Student(String name, int age) {
    }

    public static void main(String[] args) {
        Student s = new Student("Aylin", 20);

        System.out.println("Student: " + s);
        System.out.println("name() = " + s.name());
        System.out.println("age() = " + s.age());
    }
}

