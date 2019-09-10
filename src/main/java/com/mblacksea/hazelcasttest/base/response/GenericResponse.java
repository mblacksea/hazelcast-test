package com.mblacksea.hazelcasttest.base.response;

import com.mblacksea.hazelcasttest.base.AbstractGenericType;
import com.mblacksea.hazelcasttest.base.util.GeneralEnumDefination.OperationResultCodeType;

public class GenericResponse<T extends AbstractGenericType> {
  protected T data;
  protected OperationResult operationResult;

  public GenericResponse(T data, OperationResult operationResult) {
    this.data = data;
    this.operationResult = operationResult;
  }

  public GenericResponse() {
    this(null, null);
  }

  public GenericResponse(OperationResult operationResult) {
    this(null, operationResult);
  }

  public static GenericResponse createSuccessResponse() {
    return new GenericResponse(OperationResult.newInstance(OperationResultCodeType.SUCCESS));
  }

  public static GenericResponse createErrorResponse() {
    return new GenericResponse(OperationResult.newInstance(OperationResultCodeType.ERROR));
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public OperationResult getOperationResult() {
    return operationResult;
  }

  public void setOperationResult(OperationResult operationResult) {
    this.operationResult = operationResult;
  }
}
