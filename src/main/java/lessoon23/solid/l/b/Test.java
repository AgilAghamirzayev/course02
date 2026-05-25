package lessoon23.solid.l.b;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();

        List<Bird> birds = List.of(sparrow, penguin);
        Test test = new Test();

        birds.forEach(test::makeBirdFly);
    }

    public void makeBirdFly(Bird bird) {
        bird.fly();
    }
}
