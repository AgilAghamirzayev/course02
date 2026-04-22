package l11.enums.methodhiding.overrinding.methodhiding.part3;

// Methods that are already overridden by other candidates are ignored.
// This circumstance can arise when supertypes share a common ancestor.
public class Dragon implements EggLayer, FireBreather {
    public static void main (String... args) {
        Dragon myApp = new Dragon();
        System.out.println(myApp.identifyMyself());
    }
}