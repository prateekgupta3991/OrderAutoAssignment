package assignment.auto.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by prateekgupta on 28/01/18.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryExecutiveDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer id;
  private Date last_order_delivered_time;
  private String current_location;

  public DeliveryExecutiveDTO() {
  }

  public DeliveryExecutiveDTO(Integer id, Date last_order_delivered_time, String current_location) {
    this.id = id;
    this.last_order_delivered_time = last_order_delivered_time;
    this.current_location = current_location;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getLast_order_delivered_time() {
    return last_order_delivered_time;
  }

  public void setLast_order_delivered_time(Date last_order_delivered_time) {
    this.last_order_delivered_time = last_order_delivered_time;
  }

  public String getCurrent_location() {
    return current_location;
  }

  public void setCurrent_location(String current_location) {
    this.current_location = current_location;
  }

  @Override
  public String toString() {
    return "DeliveryExecutiveDTO{" +
        "id=" + id +
        ", last_order_delivered_time=" + last_order_delivered_time +
        ", current_location='" + current_location + '\'' +
        '}';
  }
}
