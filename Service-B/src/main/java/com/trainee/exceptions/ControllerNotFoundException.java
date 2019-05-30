package com.trainee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ControllerNotFoundException extends RuntimeException {

  public ControllerNotFoundException(String message) {
    super(message);
    // TODO Auto-generated constructor stub
  }

}
