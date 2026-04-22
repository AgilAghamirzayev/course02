package l11.enums.methodhiding.enums.part1;


public enum Status {
    NEW, SHIPPED, DELIVERED
}

//
//final class Status extends Enum<Status> {
//    public static final Status NEW = new Status("NEW", 0);
//    public static final Status SHIPPED = new Status("SHIPPED", 1);
//    public static final Status DELIVERED = new Status("DELIVERED", 2);
//
//    private static final Status[] VALUES = {NEW, SHIPPED, DELIVERED};
//
//    private Status(String name, int ordinal) {
//        super(name, ordinal);
//    }
//
//    public static Status[] values() {
//        return VALUES.clone();
//    }
//
//}

