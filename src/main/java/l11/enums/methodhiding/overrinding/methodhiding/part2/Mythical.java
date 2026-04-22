package l11.enums.methodhiding.overrinding.methodhiding.part2;

public interface Mythical {

    default public String identifyMyself() {
        return "I am a mythical creature.";
    }

}