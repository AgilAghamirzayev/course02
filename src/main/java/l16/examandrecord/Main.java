package l16.examandrecord;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person aylin = new Person("Aylin", new ArrayList<>(List.of("Java", "Python", "C++")));
        System.out.println(aylin);

        aylin.getName();
        aylin.getCourses();

        aylin.getCourses().add("C#");

        System.out.println(aylin);
    }
}
