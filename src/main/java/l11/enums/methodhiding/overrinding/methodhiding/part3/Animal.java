package l11.enums.methodhiding.overrinding.methodhiding.part3;

public interface Animal {
    default public String identifyMyself() {
        return "I am an animal.";
    }
}