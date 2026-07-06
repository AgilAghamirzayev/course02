package lesson23.solid.o.g;

class PaymentProcessor {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.process(new PayPalPayment());
    }

    public void process(PaymentMethod paymentMethod) {
        paymentMethod.pay();
    }
}
