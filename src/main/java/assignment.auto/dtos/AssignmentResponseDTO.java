package assignment.auto.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prateekgupta on 28/01/18.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignmentResponseDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private List<AssignmentDTO> Assignments;

  public AssignmentResponseDTO() {
    Assignments = new ArrayList<>();
  }

  public AssignmentResponseDTO(List<AssignmentDTO> assignments) {
    Assignments = assignments;
  }

  public List<AssignmentDTO> getAssignments() {
    return Assignments;
  }

  public void setAssignments(List<AssignmentDTO> assignments) {
    Assignments = assignments;
  }

  @Override
  public String toString() {
    return "AssignmentResponseDTO{" +
        "Assignments=" + Assignments +
        '}';
  }
}
