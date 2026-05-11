package l14.colelctions.inclass.s5;

import java.util.*;

public class SafeRemoveWithIteratorDemo {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) {
            Integer x = it.next();
            if (x % 2 == 0) {
                it.remove();
            }
        }

        System.out.println(nums); // [1, 3, 5]
    }
}