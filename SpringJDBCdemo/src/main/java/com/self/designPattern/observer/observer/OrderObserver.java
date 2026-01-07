package observer.observer;

import observer.event.OrderEvent;

public interface OrderObserver {
    void onOrder(OrderEvent event);
}