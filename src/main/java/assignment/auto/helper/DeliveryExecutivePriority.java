package assignment.auto.helper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Queue;
import assignment.auto.bo.DeliveryExecutiveBo;

/**
 * Created by prateekgupta on 28/01/18.
 */
@Component
public interface DeliveryExecutivePriority extends Priority {

  void createDeliveryExecutiveQueue(List<DeliveryExecutiveBo> deliveryExecutiveBoList);

  void addDeliveryExecutive(DeliveryExecutiveBo deliveryExecutiveBo);

  DeliveryExecutiveBo getDeliveryExecutive();

  void addDataToQueue(Queue<DeliveryExecutiveBo> deliveryExecutiveBoPriorityQueue, DeliveryExecutiveBo deliveryExecutiveBo);

}
