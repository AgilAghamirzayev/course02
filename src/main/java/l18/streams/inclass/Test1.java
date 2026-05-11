package l18.streams.inclass;

import java.util.List;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {

        List<Integer> limit = Stream.iterate(2, n -> n + 2)
                .peek(System.out::println)
                .limit(100).toList();

        Stream<Integer> limit1 = limit.stream();
        limit.forEach(System.out::println);
//        limit.forEach(System.out::println);

//        limit1.forEach(System.out::println);

    }
}
