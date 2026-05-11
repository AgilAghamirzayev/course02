package l15.generics;

import java.util.ArrayList;
import java.util.List;

public class Test8 {  //PECS -> Producer extend, Consumer super

    public static void main(String[] args) {
        Test8 test8 = new Test8();

        ArrayList<Number> numbers = new ArrayList<>(List.of(1, 2, 3));
        test8.addNumbers(numbers);
        test8.printNumbers(numbers, numbers);

        List<Integer> l1 = new ArrayList<>();
        List<Number> l2 = new ArrayList<>();
        List<Object> l3 = new ArrayList<>();

        l1.add(1);
        l2.add(1);
        l3.add(1);

    }

    public void printNumbers(List<? extends Number> list1, List<? super Integer> list2) {
        list2.add(2);
    }

    public void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(2);
    }


//    public static <T, D> T firstNonNull(T first, T second) {
//        return first != null ? first : second;
//    }

    public static <T, D> D firstNonNull(T first, D d) {
       return d;
    }


}
