package assignment.auto.helper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Queue;
import assignment.auto.bo.OrdersBo;

/**
 * Created by prateekgupta on 28/01/18.
 */

@Component
public abstract class OrderPriority extends Priority{

  public abstract void createOrderQueue(List<OrdersBo> orderList);

  public abstract void addOrder(OrdersBo order);

  public abstract OrdersBo getOrder();

  public abstract void addDataToQueue(Queue<OrdersBo> orderPriorityQueue, OrdersBo order);
}
