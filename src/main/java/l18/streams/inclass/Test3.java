package l18.streams.inclass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args) {
        List<String> departmentList = Arrays.asList("Supply", "HR", "Sales", "Marketing");

        departmentList.stream()
//                .peek(x -> System.out.println("1: " + x + " "))
                .filter(w -> w.startsWith("S"))
//                .peek(x -> System.out.println("2: " + x + " "))
                .map(w -> w.length())
                .forEach(System.out::println);

    }
}
