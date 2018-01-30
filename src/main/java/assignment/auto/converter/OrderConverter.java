package assignment.auto.converter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import assignment.auto.bo.OrdersBo;
import assignment.auto.dtos.OrderDTO;

/**
 * Created by prateekgupta on 28/01/18.
 */

@Component
public class OrderConverter {

  public List<OrdersBo> convert(List<OrderDTO> dto) {

    List<OrdersBo> ordersBoList = new ArrayList<>();
    for(OrderDTO orderDto : dto) {
      OrdersBo bo = new OrdersBo();
      bo.setId(orderDto.getId());
      bo.setOrderedTime(orderDto.getOrdered_time());
      String [] latLong = orderDto.getRestaurant_location().split(",");
      bo.setCurrentLatitude(Double.parseDouble(latLong[0]));
      bo.setCurrentLongitude(Double.parseDouble(latLong[1]));
      ordersBoList.add(bo);
    }
    return ordersBoList;
  }

  public List<OrderDTO> reverseConvert(List<OrdersBo> bo) {

    List<OrderDTO> orderDTOList = new ArrayList<>();
    for(OrdersBo ordersBo : bo) {
      OrderDTO dto = new OrderDTO();
      dto.setId(ordersBo.getId());
      dto.setOrdered_time(ordersBo.getOrderedTime());
      dto.setRestaurant_location(ordersBo.getCurrentLatitude()+","+ordersBo.getCurrentLongitude());
      orderDTOList.add(dto);
    }
    return orderDTOList;
  }
}
