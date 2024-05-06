package com.qpassessment.groceryapp.controller;

import com.qpassessment.groceryapp.helper.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

  @GetMapping("/")
  public ResponseEntity<String> health() {
    String response = Constants.SERVICE_HEALTH_MESSAGE;
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
