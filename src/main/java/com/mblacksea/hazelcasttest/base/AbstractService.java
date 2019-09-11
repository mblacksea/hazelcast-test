package com.mblacksea.hazelcasttest.base;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StopWatch;

public class AbstractService {
  protected final Logger logger = LogManager.getLogger(this.getClass());

  protected void performanceLog(StopWatch stopWatch, String methodName, String msName) {
    logger.info("execution-time: " + StringUtils.leftPad("" + stopWatch.getTotalTimeMillis(), 5) + " ms - " + methodName + "." + msName);
  }

  protected void performanceErrorLog(StopWatch stopWatch, String methodName, String msName) {
    logger.info("execution-time-error: " + StringUtils.leftPad("" + stopWatch.getTotalTimeMillis(), 5) + " ms - " + methodName + "." + msName);
  }
}
