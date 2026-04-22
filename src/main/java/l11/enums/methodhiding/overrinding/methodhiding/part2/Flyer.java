package l11.enums.methodhiding.overrinding.methodhiding.part2;

public interface Flyer {

    default public String identifyMyself() {
        return "I am able to fly.";
    }

}