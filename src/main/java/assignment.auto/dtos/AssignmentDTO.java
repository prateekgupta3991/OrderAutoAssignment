package assignment.auto.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by prateekgupta on 28/01/18.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignmentDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer order_id;
  private Integer de_id;

  public AssignmentDTO() {
  }

  public AssignmentDTO(Integer order_id, Integer de_id) {
    this.order_id = order_id;
    this.de_id = de_id;
  }

  public Integer getOrder_id() {
    return order_id;
  }

  public void setOrder_id(Integer order_id) {
    this.order_id = order_id;
  }

  public Integer getDe_id() {
    return de_id;
  }

  public void setDe_id(Integer de_id) {
    this.de_id = de_id;
  }

  @Override
  public String toString() {
    return "AssignmentDTO{" +
        "order_id=" + order_id +
        ", de_id=" + de_id +
        '}';
  }
}
