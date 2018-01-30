package assignment.auto.helper;

import org.springframework.stereotype.Component;

import java.util.List;
import assignment.auto.bo.DeliveryExecutiveBo;

/**
 * Created by prateekgupta on 28/01/18.
 */
@Component
public abstract class DeliveryExecutivePriority extends Priority {

  public abstract void createDeliveryExecutiveQueue(List<DeliveryExecutiveBo> deliveryExecutiveBoList);

  public abstract void addDeliveryExecutive(DeliveryExecutiveBo deliveryExecutiveBo);

  public abstract DeliveryExecutiveBo getDeliveryExecutive();

  public abstract void removeDeliveryExecutive(DeliveryExecutiveBo deliveryExecutiveBo);

}
