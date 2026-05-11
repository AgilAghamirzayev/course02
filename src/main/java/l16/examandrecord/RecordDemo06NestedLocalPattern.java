package l16.examandrecord;

public class RecordDemo06NestedLocalPattern {

    public record OrderEvent(String orderId, String status) {
    }

    public static class ReportService {
        public record Row(String label, long count) {
        }
    }

    public static void main(String[] args) {
        ReportService.Row row = new ReportService.Row("Paid Orders", 17);
        System.out.println("Nested record: " + row);

        record Tmp(int id, String name) {
        }
        Tmp t = new Tmp(1, "Demo");
        System.out.println("Local record: " + t);

        Object obj = new OrderEvent("ORD-1", "PAID");
        if (obj instanceof OrderEvent(String orderId, String status)) {
            System.out.println("Pattern match => " + orderId + " -> " + status);
        }
    }


}

