package l4.controlflow.loops.inclass;

public class Test10 {

    public static void main(String[] args) {
        int step = 1000;

        do {
            System.out.println("Addim at: " + step);
            step++;
        } while (step <= 100);

    }

}
