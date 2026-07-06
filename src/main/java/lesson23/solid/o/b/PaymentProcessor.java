package lesson23.solid.o.b;

class PaymentProcessor {

    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.pay("CARD");
    }

    public void pay(String paymentType) {

        if (paymentType.equals("CARD")) {
            System.out.println("Paid by card");
        } else if (paymentType.equals("CASH")) {
            System.out.println("Paid by cash");
        } else if (paymentType.equals("PAYPAL")) {
            System.out.println("Paid by PayPal");
        } else if (paymentType.equals("APPLE_PAY")) {
            System.out.println("Paid by Apple Pay");
        }

    }
}