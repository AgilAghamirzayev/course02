package l16.examandrecord;

public class RecordLessonRunner {
    public static void main(String[] args) {
        run("Demo01 Basic", RecordDemo01Basic::main);
        run("Demo02 Validation", RecordDemo02Validation::main);
        run("Demo03 Constructors and Methods", RecordDemo03ConstructorsAndMethods::main);
        run("Demo04 Defensive Copy", RecordDemo04DefensiveCopy::main);
        run("Demo05 Equals HashCode MapKey", RecordDemo05EqualsHashCodeMapKey::main);
        run("Demo06 Nested Local Pattern", RecordDemo06NestedLocalPattern::main);
        run("Demo07 Sealed Records", RecordDemo07SealedRecords::main);
        run("Demo08 Real World Checkout", RecordDemo08RealWorldCheckout::main);
    }

    @FunctionalInterface
    interface DemoMain {
        void run(String[] args);
    }

    private static void run(String title, DemoMain demo) {
        System.out.println();
        System.out.println("=== " + title + " ===");
        demo.run(new String[0]);
    }
}

