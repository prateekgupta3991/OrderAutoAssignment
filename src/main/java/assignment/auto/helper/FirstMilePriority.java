package assignment.auto.helper;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import assignment.auto.bo.DeliveryExecutiveBo;
import assignment.auto.bo.OrdersBo;
import assignment.auto.util.Haversine;

/**
 * Created by prateekgupta on 28/01/18.
 */

@Component
public class FirstMilePriority extends DeliveryExecutivePriority {

  Queue<DeliveryExecutiveBo> firstMilePriorityQueue;

  public FirstMilePriority() {
    super();
    this.firstMilePriorityQueue = new PriorityQueue<>(firstMileComparator);
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
   * create a max priority queue based on DE distance from order
   * @param deliveryExecutiveBoList
   * @param order
   */
  public void createDeliveryExecutiveQueue(List<DeliveryExecutiveBo> deliveryExecutiveBoList, OrdersBo order) {
    for(DeliveryExecutiveBo de : deliveryExecutiveBoList) {
      updateDistanceFromRestaurant(de, order);
      addDataToQueue(firstMilePriorityQueue, de);
    }
  }

  /**
   * update DE's distance from order location in BO
   * @param de
   * @param order
   */
  private void updateDistanceFromRestaurant(DeliveryExecutiveBo de, OrdersBo order) {

    de.setDistanceFromOrder(Haversine.distance(de.getCurrentLatitude(), de.getCurrentLongitude(),
        order.getCurrentLatitude(), order.getCurrentLongitude()));
  }

  /**
   * add a DE to queue
   * @param deliveryExecutiveBo
   */
  @Override
  public void addDeliveryExecutive(DeliveryExecutiveBo deliveryExecutiveBo) {
    addDataToQueue(firstMilePriorityQueue, deliveryExecutiveBo);
  }

  /**
   * return the max DE if not null
   * @return
   */
  public DeliveryExecutiveBo getDeliveryExecutive() {
    if(!firstMilePriorityQueue.isEmpty())
      return firstMilePriorityQueue.remove();
    return null;
  }

  /**
   * removes a DE from the queue
   * @param deliveryExecutiveBo
   */
  @Override
  public void removeDeliveryExecutive(DeliveryExecutiveBo deliveryExecutiveBo) {
    if(!firstMilePriorityQueue.isEmpty()) {
      firstMilePriorityQueue.remove(deliveryExecutiveBo);
    }
  }

  /**
   * add a new DE to the queue
   * @param firstMilePriorityQueue
   * @param deliveryExecutiveBo
   */
  public void addDataToQueue(Queue<DeliveryExecutiveBo> firstMilePriorityQueue, DeliveryExecutiveBo deliveryExecutiveBo) {
    firstMilePriorityQueue.add(deliveryExecutiveBo);
  }

  /**
   * comparator on priority distance from order
   */
  private Comparator<DeliveryExecutiveBo> firstMileComparator = new Comparator<DeliveryExecutiveBo>() {
    @Override
    public int compare(DeliveryExecutiveBo de1, DeliveryExecutiveBo de2) {
      return -1 * de1.getDistanceFromOrder().compareTo(de2.getDistanceFromOrder());
    }
  };

}
