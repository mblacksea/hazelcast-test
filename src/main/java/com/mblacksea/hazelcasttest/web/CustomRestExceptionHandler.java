package com.mblacksea.hazelcasttest.web;

import com.mblacksea.hazelcasttest.base.ApiError;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

  private final Logger logger = LogManager.getLogger(this.getClass());

  @ExceptionHandler({Exception.class})
  public ResponseEntity<ApiError> handleAll(final Exception ex, final WebRequest request) {
    String logId = this.logError(ex, request);
    final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "", "Error Id : " + logId);
    return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
  }

  private String logError(final Exception exception, final WebRequest request) {
    String logId = "" + System.currentTimeMillis();
    logger.error("error id : " + logId + " - url: " + this.obtainUrl(request), exception);
    return logId;
  }

  private String obtainUrl(final WebRequest request) {
    HttpServletRequest rr = ((ServletWebRequest) request).getRequest();
    String url = rr.getRequestURL().toString();
    if (!StringUtils.isEmpty(rr.getQueryString())) {
      url += "?" + rr.getQueryString();
    }
    return url;
  }

}
