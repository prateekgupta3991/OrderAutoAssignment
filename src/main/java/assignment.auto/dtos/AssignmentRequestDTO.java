package assignment.auto.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * Created by prateekgupta on 28/01/18.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignmentRequestDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private List<OrderDTO> Orders;
  private List<DeliveryExecutiveDTO> DEs;

  public AssignmentRequestDTO() {
  }

  public AssignmentRequestDTO(List<OrderDTO> orders, List<DeliveryExecutiveDTO> DEs) {
    Orders = orders;
    this.DEs = DEs;
  }

  public List<OrderDTO> getOrders() {
    return Orders;
  }

  public void setOrders(List<OrderDTO> orders) {
    Orders = orders;
  }

  public List<DeliveryExecutiveDTO> getDEs() {
    return DEs;
  }

  public void setDEs(List<DeliveryExecutiveDTO> DEs) {
    this.DEs = DEs;
  }

  @Override
  public String toString() {
    return "AssignmentRequestDTO{" +
        "OrdersBo=" + Orders +
        ", DEs=" + DEs +
        '}';
  }
}
