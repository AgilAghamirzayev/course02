package l15.generics;

import java.util.Arrays;

public class Test4 {

    public static void main(String[] args) {
        Integer[] a = {76, 55, 58, 23, 6, 50};
        Character[] c = {'v', 'g', 'a', 'c', 'x', 'd', 't'};
        String[] s = {"Vali", "Ali", "Ahmed", "Aysu", "Leman", "Orkhan", "Lale"};

        System.out.print("Sorted Integer array :  ");
        bubbleSort(a);

        System.out.print("Sorted Character array :  ");
        bubbleSort(c);

        System.out.print("Sorted String array :  ");
        bubbleSort(s);
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(j, j + 1, array);
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

    public static <T> void swap(int i, int j, T[] a) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
