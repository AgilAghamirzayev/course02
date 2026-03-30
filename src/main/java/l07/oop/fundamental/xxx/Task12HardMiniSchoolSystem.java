package l07.oop.fundamental.xxx;

import java.util.Scanner;

public class Task12HardMiniSchoolSystem {

    static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getInfo() {
            return "Student: " + name + ", Age: " + age;
        }
    }

    // 🔹 Teacher class
    static class Teacher {
        private String name;
        private String subject;

        public Teacher(String name, String subject) {
            this.name = name;
            this.subject = subject;
        }

        public String getInfo() {
            return "Teacher: " + name + ", Subject: " + subject;
        }
    }

    // 🔹 Service class
    static class SchoolService {

        private Student[] students = new Student[100];
        private Teacher[] teachers = new Teacher[100];

        private int studentCount = 0;
        private int teacherCount = 0;

        public void addStudent(String name, int age) {
            if (studentCount < students.length) {
                students[studentCount++] = new Student(name, age);
                System.out.println("✅ Student added.");
            } else {
                System.out.println("❌ Student list is full.");
            }
        }

        public void addTeacher(String name, String subject) {
            if (teacherCount < teachers.length) {
                teachers[teacherCount++] = new Teacher(name, subject);
                System.out.println("✅ Teacher added.");
            } else {
                System.out.println("❌ Teacher list is full.");
            }
        }

        public void listAllPeople() {
            System.out.println("\n📚 Students:");
            for (int i = 0; i < studentCount; i++) {
                System.out.println(students[i].getInfo());
            }

            System.out.println("\n👨‍🏫 Teachers:");
            for (int i = 0; i < teacherCount; i++) {
                System.out.println(teachers[i].getInfo());
            }
        }
    }

    // 🔹 MAIN (Menu)
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SchoolService service = new SchoolService();

        while (true) {
            System.out.println("\n===== SCHOOL MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. List All People");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // fix buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String sName = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    service.addStudent(sName, age);
                    break;

                case 2:
                    System.out.print("Enter teacher name: ");
                    String tName = scanner.nextLine();

                    System.out.print("Enter subject: ");
                    String subject = scanner.nextLine();

                    service.addTeacher(tName, subject);
                    break;

                case 3:
                    service.listAllPeople();
                    break;

                case 0:
                    System.out.println("👋 Exit...");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Invalid option");
            }
        }
    }
}