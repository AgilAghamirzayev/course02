package l11.enums.methodhiding.overrinding.methodhiding.part0;

public class Test2 {
    public static void main(String[] args) {
        Parent myParent = new Child();
        System.out.println(myParent.name);

        Child c = new Child();
        System.out.println(c.name);
        System.out.println(((Parent) c).name);
    }
}
