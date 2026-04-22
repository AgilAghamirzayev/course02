package l11.enums.methodhiding.overrinding.methodhiding.part3;

public interface EggLayer extends Animal {
    default public String identifyMyself() {
        return "I am able to lay eggs.";
    }
}