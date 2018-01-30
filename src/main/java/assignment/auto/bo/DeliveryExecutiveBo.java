package assignment.auto.bo;

import java.util.Date;

/**
 * Created by prateekgupta on 28/01/18.
 */
public class DeliveryExecutiveBo {

  private Integer id;
  private Date lastOrderDeliveredTime;
  private Double currentLatitude;
  private Double currentLongitude;
  private Double distanceFromOrder;
  private OrdersBo ordersBo;

  public DeliveryExecutiveBo() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getLastOrderDeliveredTime() {
    return lastOrderDeliveredTime;
  }

  public void setLastOrderDeliveredTime(Date lastOrderDeliveredTime) {
    this.lastOrderDeliveredTime = lastOrderDeliveredTime;
  }

  public Double getCurrentLatitude() {
    return currentLatitude;
  }

  public void setCurrentLatitude(Double currentLatitude) {
    this.currentLatitude = currentLatitude;
  }

  public Double getCurrentLongitude() {
    return currentLongitude;
  }

  public void setCurrentLongitude(Double currentLongitude) {
    this.currentLongitude = currentLongitude;
  }

  public Double getDistanceFromOrder() {
    return distanceFromOrder;
  }

  public void setDistanceFromOrder(Double distanceFromOrder) {
    this.distanceFromOrder = distanceFromOrder;
  }

  public OrdersBo getOrdersBo() {
    return ordersBo;
  }

  public void setOrdersBo(OrdersBo ordersBo) {
    this.ordersBo = ordersBo;
  }

  @Override
  public String toString() {
    return "DeliveryExecutiveBo{" +
        "id=" + id +
        ", lastOrderDeliveredTime=" + lastOrderDeliveredTime +
        ", currentLatitude=" + currentLatitude +
        ", currentLongitude=" + currentLongitude +
        ", distanceFromOrder=" + distanceFromOrder +
        ", ordersBo=" + ordersBo +
        '}';
  }
}
