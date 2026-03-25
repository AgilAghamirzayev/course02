package l05.arrays.strings.inclass.inclass;

import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
        int[] nums = new int[100];
        System.out.println(Arrays.toString(nums));
        System.out.println(nums.length);

        int counter = 0;
        for (int index = 0; index < nums.length; counter++) {
            if (counter % 2 == 1) {
                nums[index] = counter;
                index++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
