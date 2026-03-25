package l05.arrays.strings.inclass.inclass;

import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
        int[] nums = new int[10];

        nums[0] = 1;
        nums[7] = 100;

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < 10; i++) {
            System.out.printf("%d -> %d%n", i, nums[i]);
        }

    }
}
