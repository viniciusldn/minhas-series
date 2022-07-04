package com.trybe.acc.java.minhasseries.exception;

public class DataErrorException {
  private String error;

  public DataErrorException(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
