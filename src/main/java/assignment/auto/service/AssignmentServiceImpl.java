package assignment.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import assignment.auto.bo.DeliveryExecutiveBo;
import assignment.auto.bo.OrdersBo;
import assignment.auto.constants.Constant;
import assignment.auto.converter.DeliveryExecutiveConverter;
import assignment.auto.converter.OrderConverter;
import assignment.auto.dtos.AssignmentDTO;
import assignment.auto.dtos.AssignmentRequestDTO;
import assignment.auto.dtos.AssignmentResponseDTO;
import assignment.auto.helper.DeliveryExecutiveWaitTimePriority;
import assignment.auto.helper.FirstMilePriority;
import assignment.auto.helper.OrderDelayTimePriority;

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

  /**
   * does auto assignment by - getting most delayed order then collecting a list of all DE within a
   * constant distance and then selecting the DE with max wait time.
   * @param assignmentRequestDTO
   * @return
   */
  @Override
  public AssignmentResponseDTO computeAssignment(AssignmentRequestDTO assignmentRequestDTO) {
    List<OrdersBo> ordersBos = orderConverter.convert(assignmentRequestDTO.getOrders());
    List<DeliveryExecutiveBo> deliveryExecutiveBos = deliveryExecutiveConverter.convert(assignmentRequestDTO.getDEs());
    AssignmentResponseDTO assignmentResponseDTO = new AssignmentResponseDTO();

    orderDelayTimePriority.createOrderQueue(ordersBos);
    for (int cntr = 0; cntr < assignmentRequestDTO.getOrders().size(); cntr++) {

      if(deliveryExecutiveBos.isEmpty()) {
        break;
      }
      List<DeliveryExecutiveBo> deAvailable = new ArrayList<>();
      deAvailable.addAll(deliveryExecutiveBos);

      // Get max delayed order
      OrdersBo orderByDelayTime = orderDelayTimePriority.getOrder();
      // Get list of DE within the area range
      deAvailable = getDeByDistance(deAvailable, orderByDelayTime);
      // Get DE with max wait time within the area range

      if(!deAvailable.isEmpty()) {
        DeliveryExecutiveBo deByWaitTime = getDeByMaxWaitTime(deAvailable);
        deliveryExecutiveBos = removeSelectedDeliveryExecutive(deliveryExecutiveBos, deByWaitTime);

        AssignmentDTO assignmentDTO = new AssignmentDTO();
        assignmentDTO.setDe_id(deByWaitTime.getId());
        assignmentDTO.setOrder_id(orderByDelayTime.getId());
        assignmentResponseDTO.getAssignments().add(assignmentDTO);
      }
    }

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

  /**
   * returns a list of DE BOs after removing a deByDistance and updating the DE wait time
   * priority queue
   * @param deAvailable
   * @param deByDistance
   * @return
   */
  private List<DeliveryExecutiveBo> removeSelectedDeliveryExecutive(List<DeliveryExecutiveBo> deAvailable, DeliveryExecutiveBo deByDistance) {
    deAvailable.remove(deByDistance);
    deliveryExecutiveWaitTimePriority.removeDeliveryExecutive(deByDistance);
    return deAvailable;
  }

  /**
   * returns a list of DE BOs whose first mile distance is less than a constant area
   * @param deliveryExecutiveBos
   * @param orderByDelayTime
   * @return
   */
  public List<DeliveryExecutiveBo> getDeByDistance(List<DeliveryExecutiveBo> deliveryExecutiveBos, OrdersBo orderByDelayTime) {
    firstMilePriority.createDeliveryExecutiveQueue(deliveryExecutiveBos, orderByDelayTime);
    DeliveryExecutiveBo deByDistance = null;
    while (true) {
      deByDistance = firstMilePriority.getDeliveryExecutive();
      if (deByDistance == null) {
        break;
      }
      if (deByDistance.getDistanceFromOrder() < Constant.orderArea) {
        break;
      } else {
        deliveryExecutiveBos.remove(deByDistance);
      }
    }
    return deliveryExecutiveBos;
  }
}
