package observer.observer;

import observer.event.OrderEvent;

public class EmailObserver implements OrderObserver {
    public void onOrder(OrderEvent event) {
        System.out.println("Email sent for " + event.getId());
    }
}