package assignment.auto.bo;

import java.util.Date;

/**
 * Created by prateekgupta on 28/01/18.
 */
public class OrdersBo {

  private Integer id;
  private Date orderedTime;
  private Double currentLatitude;
  private Double currentLongitude;
  private DeliveryExecutiveBo deliveryExecutiveBo;

  public OrdersBo() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getOrderedTime() {
    return orderedTime;
  }

  public void setOrderedTime(Date orderedTime) {
    this.orderedTime = orderedTime;
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

  public DeliveryExecutiveBo getDeliveryExecutiveBo() {
    return deliveryExecutiveBo;
  }

  public void setDeliveryExecutiveBo(DeliveryExecutiveBo deliveryExecutiveBo) {
    this.deliveryExecutiveBo = deliveryExecutiveBo;
  }

  @Override
  public String toString() {
    return "OrdersBo{" +
        "id=" + id +
        ", orderedTime=" + orderedTime +
        ", currentLatitude=" + currentLatitude +
        ", currentLongitude=" + currentLongitude +
        ", deliveryExecutiveBo=" + deliveryExecutiveBo +
        '}';
  }
}
