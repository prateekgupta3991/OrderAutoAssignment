package assignment.auto.helper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Queue;
import assignment.auto.bo.OrdersBo;

/**
 * Created by prateekgupta on 28/01/18.
 */

@Component
public interface OrderPriority extends Priority{

  void createOrderQueue(List<OrdersBo> orderList);

  void addOrder(OrdersBo order);

  OrdersBo getOrder();

  void addDataToQueue(Queue<OrdersBo> orderPriorityQueue, OrdersBo order);
}
