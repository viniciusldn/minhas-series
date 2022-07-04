package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.exception.AlreadyExistsException;
import com.trybe.acc.java.minhasseries.exception.DataErrorException;
import com.trybe.acc.java.minhasseries.exception.NotFoundException;
import com.trybe.acc.java.minhasseries.exception.UnexpectedErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class AdviceController.
 */
@ControllerAdvice
public class AdviceController {

  /**
   * Handle conflict.
   *
   * @param error the error
   * @return the response entity
   */
  @ExceptionHandler({ AlreadyExistsException.class })
  public ResponseEntity<DataErrorException> handleConflict(
      RuntimeException error) {
    return ResponseEntity.status(HttpStatus.CONFLICT)
        .body(new DataErrorException(error.getMessage()));
  }

  /**
   * Handle not found.
   *
   * @param error the error
   * @return the response entity
   */
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<DataErrorException> handleNotFound(
      RuntimeException error) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new DataErrorException(error.getMessage()));
  }

  /**
   * Handle server error.
   *
   * @param error the error
   * @return the response entity
   */
  @ExceptionHandler({ UnexpectedErrorException.class, RuntimeException.class })
  public ResponseEntity<DataErrorException> handleServerError(
      RuntimeException error) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new DataErrorException(error.getMessage()));
  }

}
