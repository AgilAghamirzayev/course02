package l05.arrays.strings.addition;

public class AgesAnalysis {

    public static void main(String[] args) {

        int[] ages = {18, 25, 30, 16, 22, 40, 19};

        int sum = calculateSum(ages);
        double average = calculateAverage(ages);
        int min = findMinimum(ages);
        int[] sortedAges = sortAges(ages.clone()); // clone to keep original safe

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Minimum age: " + min);

        System.out.print("Sorted ages: ");
        for (int age : sortedAges) {
            System.out.print(age + " ");
        }
    }

    // 1️⃣ Calculate Sum
    public static int calculateSum(int[] ages) {
        int sum = 0;

        for (int age : ages) {
            sum += age;
        }

        return sum;
    }

    // 2️⃣ Calculate Average
    public static double calculateAverage(int[] ages) {
        if (ages == null || ages.length == 0) {
            return 0;
        }

        int sum = calculateSum(ages);
        return (double) sum / ages.length;
    }

    // 3️⃣ Find Minimum Age
    public static int findMinimum(int[] ages) {
        if (ages == null || ages.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int min = ages[0];

        for (int age : ages) {
            if (age < min) {
                min = age;
            }
        }

        return min;
    }

    // 4️⃣ Sort Ages (Bubble Sort)
    public static int[] sortAges(int[] ages) {
        if (ages == null || ages.length == 0) {
            return ages;
        }

        for (int i = 0; i < ages.length - 1; i++) {
            for (int j = 0; j < ages.length - 1 - i; j++) {
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