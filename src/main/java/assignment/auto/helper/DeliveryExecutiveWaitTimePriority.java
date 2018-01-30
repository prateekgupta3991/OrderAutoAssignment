package assignment.auto.helper;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import assignment.auto.bo.DeliveryExecutiveBo;

/**
 * Created by prateekgupta on 28/01/18.
 */

@Component
public class DeliveryExecutiveWaitTimePriority implements DeliveryExecutivePriority {

  Queue<DeliveryExecutiveBo> deliveryExecutivePriorityQueue;

  public DeliveryExecutiveWaitTimePriority() {
    this.deliveryExecutivePriorityQueue = new PriorityQueue<>(waitTimeComparator);
  }

  /**
   * create a max priority queue based on last order delivered time
   * @param deliveryExecutiveBoList
   */
  public void createDeliveryExecutiveQueue(List<DeliveryExecutiveBo> deliveryExecutiveBoList) {
    for(DeliveryExecutiveBo de : deliveryExecutiveBoList) {
      addDataToQueue(deliveryExecutivePriorityQueue, de);
    }
  }

  /**
   * add a DE to queue
   * @param deliveryExecutiveBo
   */
  public void addDeliveryExecutive(DeliveryExecutiveBo deliveryExecutiveBo) {
    addDataToQueue(deliveryExecutivePriorityQueue, deliveryExecutiveBo);
  }

  /**
   * return the max DE if not null
   * @return
   */
  public DeliveryExecutiveBo getDeliveryExecutive() {
    if(!deliveryExecutivePriorityQueue.isEmpty()) {
      return deliveryExecutivePriorityQueue.remove();
    }
    return null;
  }

  /**
   * removes a DE from the queue
   * @param deliveryExecutiveBo
   */
  public void removeDeliveryExecutive(DeliveryExecutiveBo deliveryExecutiveBo) {
    if(!deliveryExecutivePriorityQueue.isEmpty()) {
      deliveryExecutivePriorityQueue.remove(deliveryExecutiveBo);
    }
  }

  /**
   * add a new DE to the queue
   * @param deliveryExecutivePriorityQueue
   * @param deliveryExecutiveBo
   */
  public void addDataToQueue(Queue<DeliveryExecutiveBo> deliveryExecutivePriorityQueue, DeliveryExecutiveBo deliveryExecutiveBo) {
    deliveryExecutivePriorityQueue.add(deliveryExecutiveBo);
  }

  /**
   * comparator on priority last order delivered time
   */
  private Comparator<DeliveryExecutiveBo> waitTimeComparator = new Comparator<DeliveryExecutiveBo>() {
    @Override
    public int compare(DeliveryExecutiveBo de1, DeliveryExecutiveBo de2) {
      return de1.getLastOrderDeliveredTime().compareTo(de2.getLastOrderDeliveredTime());
    }
  };
}
