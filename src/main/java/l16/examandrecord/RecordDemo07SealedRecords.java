package l16.examandrecord;

public class RecordDemo07SealedRecords {

    public sealed interface PaymentResult permits Success, Failure {
    }

    public record Success(String txId) implements PaymentResult {
    }

    public record Failure(String reason) implements PaymentResult {
    }

    public static void main(String[] args) {
        printResult(new Success("TX-1001"));
        printResult(new Failure("Insufficient balance"));
    }

    private static void printResult(PaymentResult result) {
        if (result instanceof Success s) {
            System.out.println("SUCCESS txId=" + s.txId());
        } else if (result instanceof Failure f) {
            System.out.println("FAILURE reason=" + f.reason());
        }
    }

}

