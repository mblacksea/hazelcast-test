package com.mblacksea.hazelcasttest.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StopWatch;

public class AbstractService {
  protected final Logger logger = LogManager.getLogger(this.getClass());

  protected void performanceLog(StopWatch stopWatch, String methodName, String msName, String correlationId) {
    logger.info("execution-time: " + stopWatch.getTotalTimeMillis() + " ms - " + correlationId + ": " + methodName + "." + msName);
  }

  protected void performanceErrorLog(StopWatch stopWatch, String methodName, String msName, String correlationId) {
    logger.info("execution-time-error: " + stopWatch.getTotalTimeMillis() + " ms - " + correlationId + ": " + methodName + "." + msName);
  }
}
