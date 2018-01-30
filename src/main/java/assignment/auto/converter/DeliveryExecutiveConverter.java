package assignment.auto.converter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import assignment.auto.bo.DeliveryExecutiveBo;
import assignment.auto.dtos.DeliveryExecutiveDTO;

/**
 * Created by prateekgupta on 28/01/18.
 */

@Component
public class DeliveryExecutiveConverter {

  public List<DeliveryExecutiveBo> convert(List<DeliveryExecutiveDTO> dto) {

    List<DeliveryExecutiveBo> deBoList = new ArrayList<>();
    for(DeliveryExecutiveDTO deliveryExecutiveDTO : dto) {
      DeliveryExecutiveBo bo = new DeliveryExecutiveBo();
      bo.setId(deliveryExecutiveDTO.getId());
      bo.setLastOrderDeliveredTime(deliveryExecutiveDTO.getLast_order_delivered_time());
      String [] latLong = deliveryExecutiveDTO.getCurrent_location().split(",");
      bo.setCurrentLatitude(Double.parseDouble(latLong[0]));
      bo.setCurrentLongitude(Double.parseDouble(latLong[1]));
      deBoList.add(bo);
    }
    return deBoList;
  }

  public List<DeliveryExecutiveDTO> reverseConvert(List<DeliveryExecutiveBo> bo) {

    List<DeliveryExecutiveDTO> deliveryExecutiveDTOList = new ArrayList<>();
    for(DeliveryExecutiveBo deliveryExecutiveBo : bo) {
      DeliveryExecutiveDTO dto = new DeliveryExecutiveDTO();
      dto.setId(deliveryExecutiveBo.getId());
      dto.setLast_order_delivered_time(deliveryExecutiveBo.getLastOrderDeliveredTime());
      dto.setCurrent_location(deliveryExecutiveBo.getCurrentLatitude()+"," +deliveryExecutiveBo.getCurrentLongitude());
      deliveryExecutiveDTOList.add(dto);
    }
    return deliveryExecutiveDTOList;
  }
}
