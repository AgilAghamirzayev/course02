package l18.streams.inclass;

import java.time.Instant;
import java.util.stream.IntStream;

public class Test {
//    public static int doubleIt(int n) {
//        try {
//            Thread.sleep(100);
//            System.out.println(Thread.currentThread().getName() + " is sleeping n=" + n);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return n * 2;
//    }

    public static void main(String[] args) {
        Instant now = Instant.now();

        int[] array = IntStream.range(0, 10)
                .parallel()
//                .map(Test::doubleIt)
                .map(n -> n * 2)
                .toArray();

        System.out.println(array.length);
        System.out.println("Time elapsed: " + (Instant.now().toEpochMilli() - now.toEpochMilli()) + " ms");
    }
}