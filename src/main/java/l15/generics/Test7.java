package l15.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test7 {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4));
        ArrayList<String> list2 = new ArrayList<>(List.of("1", "2", "3", "4"));

        List<?> list3 = printNumber(list1);
        List<?> list4 = printNumber(list2);

        List<Integer> list5 = printNumberN(list1);
        List<String> list6 = printNumberN(list2);

//        printNumberO(list1);
//        printNumberO(list2);
    }

    public void printNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }

    public void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(2);
    }

    public static void printNumberO(List<Object> number) {
        for (Object o : number) {
            System.out.println(o);
        }
    }

    public static List<?> printNumber(List<? extends Object> number) {
        for (Object o : number) {
            System.out.println(o);
        }
        return number;
    }

    public static <T> List<T> printNumberN(List<T> number) {
        for (T t : number) {
            System.out.println(t);
        }

        return number;
    }

}
