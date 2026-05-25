package lessoon23.solid.l.g;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Bird penguin = new Penguin();
        FlyingBird sparrow = new Sparrow();
        List<Bird> birds = List.of(penguin, sparrow);

        Test test = new Test();

//        birds.forEach(test::makeBirdFly);
        test.makeBirdFly(sparrow);
    }

    public void makeBirdFly(FlyingBird bird) {
        bird.fly();
    }
}
