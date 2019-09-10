package com.mblacksea.hazelcasttest.base;

import org.springframework.http.HttpStatus;

public class ApiError extends AbstractGenericType {

  private HttpStatus status;
  private String message;
  private String errors;

  public ApiError() {
    super();
  }

  public ApiError(final HttpStatus status, final String message, final String errors) {
    super();
    this.status = status;
    this.message = message;
    this.errors = errors;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getErrors() {
    return errors;
  }

  public void setErrors(String errors) {
    this.errors = errors;
  }
}
