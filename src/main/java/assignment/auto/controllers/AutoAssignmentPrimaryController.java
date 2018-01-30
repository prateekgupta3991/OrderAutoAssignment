package assignment.auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import assignment.auto.dtos.AssignmentRequestDTO;
import assignment.auto.dtos.AssignmentResponseDTO;
import assignment.auto.service.AssignmentServiceImpl;

/**
 * Created by prateekgupta on 28/01/18.
 */

@Controller
@RequestMapping(value="/v1")
public class AutoAssignmentPrimaryController {

  @Autowired
  private AssignmentServiceImpl assignmentServiceImpl;

  @RequestMapping(value="/assign/auto", method=RequestMethod.POST)
  public ResponseEntity<AssignmentResponseDTO> assign(@RequestBody AssignmentRequestDTO assignmentRequestDTO) {

    AssignmentResponseDTO assignmentResponseDTO = assignmentServiceImpl.computeAssignment(assignmentRequestDTO);
    return new ResponseEntity<>(assignmentResponseDTO, HttpStatus.OK);
  }
}
