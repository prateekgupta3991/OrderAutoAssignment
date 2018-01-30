package assignment.auto.helper;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import assignment.auto.bo.OrdersBo;

/**
 * Created by prateekgupta on 28/01/18.
 */

@Component
public class OrderDelayTimePriority extends OrderPriority {

  Queue<OrdersBo> orderPriorityQueue;

  public OrderDelayTimePriority() {
    super();
    this.orderPriorityQueue = new PriorityQueue<>(orderTimeComparator);
  }

  public void setPriorityRank(Integer priorityRank) {
    super.priorityRank = priorityRank;
  }

  public void setIsApplicable(Boolean isApplicable) {
    super.isApplicable = isApplicable;
  }

  public Integer getPriorityRank() {
    return super.priorityRank;
  }

  public Boolean getIsApplicable() {
    return super.isApplicable;
  }

  /**
   * creates a max priority queue based on ordered time
   * @param orderList
   */
  public void createOrderQueue(List<OrdersBo> orderList) {
    for(OrdersBo de : orderList) {
      addDataToQueue(orderPriorityQueue, de);
    }
  }

  /**
   * add order to queue
   * @param order
   */
  public void addOrder(OrdersBo order) {
    addDataToQueue(orderPriorityQueue, order);
  }

  /**
   * get order with max ordered time
   * @return
   */
  public OrdersBo getOrder() {
    if(!orderPriorityQueue.isEmpty()) {
      return orderPriorityQueue.remove();
    }
    return null;
  }

  /**
   * add data to queue
   * @param orderPriorityQueue
   * @param order
   */
  public void addDataToQueue(Queue<OrdersBo> orderPriorityQueue, OrdersBo order) {
    orderPriorityQueue.add(order);
  }

  /**
   * comparator to compare between max ordered time
   */
  private Comparator<OrdersBo> orderTimeComparator = new Comparator<OrdersBo>() {

    @Override
    public int compare(OrdersBo o1, OrdersBo o2) {
      return o1.getOrderedTime().compareTo(o2.getOrderedTime());
    }
  };

}
