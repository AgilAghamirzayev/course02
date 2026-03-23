package l04.controlflow.loops.inclass;

import java.util.Scanner;

public class Test13 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        for (int i = 1; i <= a; i++) {
          for (int j = 1; j <= a; j++) {
              System.out.printf("%d * %d = %d\n", i, j, i * j);
          }
            System.out.println();
        }

    }

}
