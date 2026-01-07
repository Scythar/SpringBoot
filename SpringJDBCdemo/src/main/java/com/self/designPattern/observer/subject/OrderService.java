package observer.subject;

import observer.event.OrderEvent;
import observer.observer.OrderObserver;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<OrderObserver> observers = new ArrayList<>();
    public void register(OrderObserver observer) {
        observers.add(observer);
    }
    public void placeOrder(String id) {
        OrderEvent event = new OrderEvent(id);
        for (OrderObserver o : observers) {
            o.onOrder(event);
        }
    }
}