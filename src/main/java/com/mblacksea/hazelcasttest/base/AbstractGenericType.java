package com.mblacksea.hazelcasttest.base;

import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AbstractGenericType implements Serializable {
  protected List<Parameter> generalParameterList = null;

  public List<Parameter> getGeneralParameterList() {
    return generalParameterList;
  }

  public void setGeneralParameterList(List<Parameter> generalParameterList) {
    this.generalParameterList = generalParameterList;
  }

  public Parameter findGeneralParameter(String shortCode) {
    if (!CollectionUtils.isEmpty(generalParameterList)) {
      for (Parameter parameter : generalParameterList) {
        if (shortCode.equalsIgnoreCase(parameter.getShortCode())) {
          return parameter;
        }
      }
    }
    return null;
  }

  public void addGeneralParameter(Parameter parameter) {
    if (generalParameterList == null) {
      generalParameterList = new ArrayList<>();
    }
    generalParameterList.add(parameter);
  }
}
