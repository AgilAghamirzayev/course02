package l04.controlflow.loops.inclass;

import java.util.Scanner;

public class Test12 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 1; i <= b; i++) {
            int c = i * a;
            System.out.printf("%d * %d = %d\n", i, a, c);
        }

    }

}
