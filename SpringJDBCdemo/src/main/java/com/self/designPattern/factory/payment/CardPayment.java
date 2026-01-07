package factory.payment;

public class CardPayment implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("CARD payment: " + amount);
    }
}