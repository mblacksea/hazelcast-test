package com.mblacksea.hazelcasttest.base.util;

import com.mblacksea.hazelcasttest.base.response.GenericResponse;
import com.mblacksea.hazelcasttest.base.response.OperationResult;

public class CommonUtil {

  public static boolean isOperationSuccessful(GenericResponse refundResult) {
    return refundResult != null && CommonUtil.isOperationSuccessful(refundResult.getOperationResult());
  }

  public static boolean isOperationSuccessful(OperationResult data) {
    return data != null && GeneralEnumDefination.OperationResultCodeType.SUCCESS.equals(data.getResultCode());
  }
}
