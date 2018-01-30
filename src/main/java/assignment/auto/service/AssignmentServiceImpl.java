package assignment.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import assignment.auto.bo.DeliveryExecutiveBo;
import assignment.auto.bo.OrdersBo;
import assignment.auto.constants.Constant;
import assignment.auto.converter.DeliveryExecutiveConverter;
import assignment.auto.converter.OrderConverter;
import assignment.auto.dtos.AssignmentRequestDTO;
import assignment.auto.dtos.AssignmentResponseDTO;
import assignment.auto.helper.DeliveryExecutivePriority;
import assignment.auto.helper.DeliveryExecutivePriorityFactory;
import assignment.auto.helper.DeliveryExecutiveWaitTimePriority;
import assignment.auto.helper.FirstMilePriority;
import assignment.auto.helper.OrderDelayTimePriority;
import assignment.auto.helper.OrderPriority;
import assignment.auto.helper.OrderPriorityFactory;

/**
 * Created by prateekgupta on 28/01/18.
 */

@Service
public class AssignmentServiceImpl implements AssignmentService {

  @Autowired
  OrderConverter orderConverter;

  @Autowired
  DeliveryExecutiveConverter deliveryExecutiveConverter;

  @Autowired
  OrderDelayTimePriority orderDelayTimePriority;

  @Autowired
  DeliveryExecutiveWaitTimePriority deliveryExecutiveWaitTimePriority;

  @Autowired
  FirstMilePriority firstMilePriority;
  private OrderDelayTimePriority orderPriority;

  /**
   * does auto assignment by - getting most delayed order then collecting a list of all DE within a
   * constant distance and then selecting the DE with max wait time.
   *
   * @param assignmentRequestDTO
   * @return
   */
  @Override
  public AssignmentResponseDTO computeAssignment(AssignmentRequestDTO assignmentRequestDTO) {
    List<OrdersBo> ordersBos = orderConverter.convert(assignmentRequestDTO.getOrders());
    List<DeliveryExecutiveBo> deliveryExecutiveBos = deliveryExecutiveConverter.convert(assignmentRequestDTO.getDEs());
    AssignmentResponseDTO assignmentResponseDTO = new AssignmentResponseDTO();

    Queue<OrderPriority> orderPriorityRank = new PriorityQueue<>();
    orderPriorityRank.add(getOrderPriority("OrderDelayTimePriority", 1));

    Queue<DeliveryExecutivePriority> deliveryExecutivePriorityRank = new PriorityQueue<>();
    deliveryExecutivePriorityRank.add(getDeliveryExecutivePriority("FirstMilePriority", 1));
    deliveryExecutivePriorityRank.add(getDeliveryExecutivePriority("DeliveryExecutiveWaitTimePriority", 2));

    List<OrdersBo> ordersAvailable = new ArrayList<>();
    ordersAvailable.addAll(ordersBos);

    for (OrderPriority x : orderPriorityRank) {
      x.createOrderQueue(ordersAvailable);
    }

    // only possible if there are threshold at each level in case of multiple priority of same
    // subtype

    return assignmentResponseDTO;
  }

  /**
   * returns a DE BO with max wait time
   * @param deAvailable
   * @return
   */
  private DeliveryExecutiveBo getDeByMaxWaitTime(List<DeliveryExecutiveBo> deAvailable) {
    deliveryExecutiveWaitTimePriority.createDeliveryExecutiveQueue(deAvailable);
    DeliveryExecutiveBo deByWaitTime = deliveryExecutiveWaitTimePriority.getDeliveryExecutive();
    return deByWaitTime;
  }

  public OrderPriority getOrderPriority(String type, Integer rank) {

    OrderPriority priority = null;
    if (Constant.orderDelayTimePriority == true) {
      priority = OrderPriorityFactory.getOrderPriority(type, rank);
    }
    return priority;
  }

  public DeliveryExecutivePriority getDeliveryExecutivePriority(String type, Integer rank) {

    DeliveryExecutivePriority priority = null;
    if (Constant.DeliveryExecutiveWaitTimePriority == true) {
      priority = DeliveryExecutivePriorityFactory.getDeliveryExecutivePriority(type, rank);
    }
    return priority;
  }
}
