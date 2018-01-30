package assignment.auto.helper;

/**
 * Created by prateekgupta on 30/01/18.
 */
public class OrderPriorityFactory {

  public static OrderPriority getOrderPriority(String type, Integer priorityRank) {
    if(type.equalsIgnoreCase("OrderWaitTimePriority")) {
      OrderDelayTimePriority priority = new OrderDelayTimePriority();
      priority.setPriorityRank(priorityRank);
      return priority;
    }
    return null;
  }
}
