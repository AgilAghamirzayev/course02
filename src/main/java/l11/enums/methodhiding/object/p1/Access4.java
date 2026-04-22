package l11.enums.methodhiding.object.p1;

public class Access4 extends Access1 {

    public static void main(String[] args) {
        Access4 access4 = new Access4();
        access4.access4();
    }

    @Override
    public void access4() {
        System.out.println("Access4");
    }

//    public void access5() {
//        System.out.println("Access4");
//    }
//

}
