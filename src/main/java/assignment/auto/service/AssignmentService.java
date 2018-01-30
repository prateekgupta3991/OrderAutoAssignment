package assignment.auto.service;

import org.springframework.stereotype.Service;

import assignment.auto.dtos.AssignmentRequestDTO;
import assignment.auto.dtos.AssignmentResponseDTO;

/**
 * Created by prateekgupta on 28/01/18.
 */
@Service
public interface AssignmentService {

  AssignmentResponseDTO computeAssignment(AssignmentRequestDTO assignmentRequestDTO);
}
