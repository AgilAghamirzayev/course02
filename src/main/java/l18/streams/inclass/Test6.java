package l18.streams.inclass;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test6 {
    public static void main(String[] args) {
        List<List<Integer>> lists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
        );

        Set<Integer> list2 = lists.stream()
                .peek(x -> System.out.println("1: " + x + " "))
                .flatMap(list -> list.stream().map(i -> i))
                .peek(x -> System.out.println("2: " + x + " "))
                .filter(i -> i % 2 == 0)
                .peek(x -> System.out.println("3: " + x + " "))
                .collect(Collectors.toSet());

        System.out.println(list2);
    }
}
