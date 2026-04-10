package l09.oop.inheritance.objectclass.inclass.nestedloop;

public class NestedLoopControl {

    public static void main(String[] args) {
        test();
    }

    public static void test() {

        OUTER_LOOP:
        for (int i = 1; i <= 3; i++) {
            System.out.println("Outer loop i = " + i);

            INNER_LOOP:
            for (int j = 1; j <= 5; j++) {

                // CONTINUE → skip only inner loop iteration
                if (j == 2) {
                    System.out.println("  continue at j = " + j);
                    continue;
                }

                // BREAK → stop only inner loop
                if (j == 4) {
                    System.out.println("  break at j = " + j);
                    break OUTER_LOOP;
                }

                // RETURN → exit entire method (both loops)
                if (i == 2 && j == 3) {
                    System.out.println("  return at i = " + i + ", j = " + j);
                    return;
                }

                System.out.println("  i = " + i + ", j = " + j);
            }

            System.out.println("---- end of inner loop ----");
        }

        System.out.println("Method finished");
    }
}