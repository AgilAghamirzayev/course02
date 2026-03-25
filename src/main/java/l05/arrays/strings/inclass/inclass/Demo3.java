package l05.arrays.strings.inclass.inclass;

import java.util.Arrays;

public class Demo3 {
    public static void main(String[] args) {
        int[] ages = new int[] {18, 25, 30, 16, 22, 40, 19};
        System.out.println(Arrays.toString(ages));

        int sum = calculateAgesSum(ages);
        int average = calculateAgesAverage(ages);
        int min = findMinimal(ages);
        int[] sortedAges = sortAges(ages.clone());

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Minimum: " + min);
        System.out.println("Sorted: " + Arrays.toString(sortedAges));
        System.out.println("Main: " + Arrays.toString(ages));
    }

    private static int calculateAgesSum(int[] ages) {
        int sum = 0;
        for (int i = 0; i < ages.length; i++) {
            sum = sum + ages[i];
        }
        return sum;
    }

    private static int calculateAgesAverage(int[] ages) {
        int sum = 0;
        for (int i = 0; i < ages.length; i++) {
            sum = sum + ages[i];
        }
        return sum / ages.length;
    }

    private static int findMinimal(int[] ages) {
        int min = ages[0];
        for (int i = 1; i < ages.length; i++) {
            if (min > ages[i]) {
                min = ages[i];
            }
        }
        return min;
    }

    private static int[] sortAges(int[] ages) {

        for (int i = 0; i < ages.length - 1; i++) {
//            System.out.println();
            for (int j = 0; j < ages.length - 1 - i; j++) {
//                System.out.print("*");
                if (ages[j] > ages[j + 1]) {
                    int temp = ages[j];
                    ages[j] = ages[j + 1];
                    ages[j + 1] = temp;
                }
            }
        }

        return ages;
    }

}
