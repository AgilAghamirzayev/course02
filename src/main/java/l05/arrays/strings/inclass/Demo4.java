package l05.arrays.strings.inclass;

import java.util.Arrays;

public class Demo4 {

    public static void main(String[] args) {
        int[][] nums = new int[2][3];

        nums[0][1] = 7;

        System.out.println(Arrays.deepToString(nums));

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

}
