package com.mblacksea.hazelcasttest.base.response;

import com.mblacksea.hazelcasttest.base.AbstractGenericType;
import com.mblacksea.hazelcasttest.base.util.GeneralEnumDefination.OperationResultCodeType;

public class OperationResult extends AbstractGenericType {
  protected OperationResultCodeType resultCode;
  protected String description;

  public static OperationResult newInstance(OperationResultCodeType resultCode) {
    OperationResult result = new OperationResult();
    result.setResultCode(resultCode);
    return result;
  }

  public static OperationResult createErrorResult(String operationResultCode) {
    return newInstance(OperationResultCodeType.ERROR);
  }

  public OperationResultCodeType getResultCode() {
    return resultCode;
  }

  public void setResultCode(OperationResultCodeType resultCode) {
    this.resultCode = resultCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
