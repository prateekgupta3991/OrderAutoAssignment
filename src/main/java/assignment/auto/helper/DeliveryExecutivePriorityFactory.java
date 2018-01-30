package assignment.auto.helper;

/**
 * Created by prateekgupta on 30/01/18.
 */
public class DeliveryExecutivePriorityFactory {

  public static DeliveryExecutivePriority getDeliveryExecutivePriority(String type, Integer priorityRank) {
    if (type.equalsIgnoreCase("FirstMilePriority")) {
      FirstMilePriority priority = new FirstMilePriority();
      priority.setPriorityRank(priorityRank);
      return priority;
    } else if (type.equalsIgnoreCase("DeliveryExecutiveWaitTimePriority")) {
      DeliveryExecutiveWaitTimePriority priority = new DeliveryExecutiveWaitTimePriority();
      priority.setPriorityRank(priorityRank);
      return priority;
    }
    return null;
  }
}
