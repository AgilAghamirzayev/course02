package l18.streams.inclass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test9 {
    public static void main(String[] args) {

        String sentence = "Java Stream stream API makes Java code cleaner and stream code readable";
        String[] split = sentence.toLowerCase().split("\\W+");

        Arrays.stream(sentence.toLowerCase().split("\\W+")) //
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()))
        ;

        ;

    }
}
