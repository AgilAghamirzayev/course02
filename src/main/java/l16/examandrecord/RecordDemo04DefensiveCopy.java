package l16.examandrecord;

import java.util.ArrayList;
import java.util.List;

public class RecordDemo04DefensiveCopy {

    public record Course(String title, List<String> topics) {
        public Course {
            topics = List.copyOf(topics);
        }
    }

    public static void main(String[] args) {
        List<String> src = new ArrayList<>();
        src.add("OOP");
        src.add("Collections");


        Course c = new Course("Java", src);
        System.out.println("Before src change: " + c.topics());

        src.add("Streams");
        System.out.println("After src change: " + c.topics());
    }
}

