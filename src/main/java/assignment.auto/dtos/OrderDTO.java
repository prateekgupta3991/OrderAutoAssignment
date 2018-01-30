package assignment.auto.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by prateekgupta on 28/01/18.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer id;
  private Date ordered_time;
  private String restaurant_location;

  public OrderDTO() {
  }

  public OrderDTO(Integer id, Date ordered_time, String restaurant_location) {
    this.id = id;
    this.ordered_time = ordered_time;
    this.restaurant_location = restaurant_location;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getOrdered_time() {
    return ordered_time;
  }

  public void setOrdered_time(Date ordered_time) {
    this.ordered_time = ordered_time;
  }

  public String getRestaurant_location() {
    return restaurant_location;
  }

  public void setRestaurant_location(String restaurant_location) {
    this.restaurant_location = restaurant_location;
  }

  @Override
  public String toString() {
    return "OrderDTO{" +
        "id=" + id +
        ", ordered_time=" + ordered_time +
        ", restaurant_location='" + restaurant_location + '\'' +
        '}';
  }
}
