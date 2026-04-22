package l13.collections.usecases;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListComparableExample {
    public static void main(String[] args) {
        // Real use case: students sorted by default rule (grade).
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Ali", 88));
        students.add(new Student("Leyla", 95));
        students.add(new Student("Murad", 76));

        Collections.sort(students); // Uses Comparable inside Student class.

        System.out.println("Comparable: default natural order inside model class.");
        System.out.println("Students sorted by grade: " + students);
    }

    static class Student implements Comparable<Student> {
        String name;
        int grade;

        Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public int compareTo(Student other) {
            return Integer.compare(this.grade, other.grade);
        }

        @Override
        public String toString() {
            return name + "(" + grade + ")";
        }
    }
}
