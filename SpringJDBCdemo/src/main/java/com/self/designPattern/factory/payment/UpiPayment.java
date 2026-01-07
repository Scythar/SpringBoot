package factory.payment;

public class UpiPayment implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("UPI payment: " + amount);
    }
}