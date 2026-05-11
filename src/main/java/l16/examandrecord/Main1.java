package l16.examandrecord;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        PersonRecord aylin1 = new PersonRecord("Aylin", new ArrayList<>(List.of("Java", "Python", "C++")));
        PersonRecord aylin2 = new PersonRecord("Aylin", List.of());
        System.out.println(aylin1);
        System.out.println(aylin1.name());
        System.out.println(aylin1.hashCode());
        System.out.println(aylin2.hashCode());

        System.out.println(aylin1 == aylin2);
        System.out.println(aylin1.equals(aylin2));


        aylin1.courses().add("Angular");
        System.out.println(aylin1);

        PersonRecord nulll = new PersonRecord(null, List.of());
        System.out.println(nulll);

    }
}
