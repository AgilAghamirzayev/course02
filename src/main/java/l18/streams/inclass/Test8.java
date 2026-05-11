package l18.streams.inclass;

import java.util.List;
import java.util.Optional;

public class Test8 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        Integer any = numbers
                .stream()
                .filter(x -> x % 10 == 0)
                .findAny()
                .get();

        System.out.println(any);

        Integer first = numbers
                .stream()
                .filter(x -> x % 10 == 0)
                .findFirst()
                .get();

        System.out.println(first);



    }
}
