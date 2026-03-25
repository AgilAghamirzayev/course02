package l06.algorithims.datastructures.incalss;

public class Test1 {

    public static void main(String[] args) {

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (int num : arr) {
            System.out.println(num);
        }

        for (int i : arr) {
            System.out.println(i);
            System.out.println(i + 1);
        }



    }
}
