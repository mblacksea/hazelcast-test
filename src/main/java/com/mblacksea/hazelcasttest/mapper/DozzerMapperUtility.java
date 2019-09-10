package com.mblacksea.hazelcasttest.mapper;

import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozzerMapperUtility {
  private Mapper mapper;

  public Mapper getMapper() {
    return mapper;
  }

  public void setMapper(Mapper mapper) {
    this.mapper = mapper;
  }

  public <T> T map(Object sourceObject, Class<T> DestinationClass, String mapId) {
    return mapper.map(sourceObject, DestinationClass, mapId);
  }

  public <T> T map(Object sourceObject, Class<T> DestinationClass) {
    return mapper.map(sourceObject, DestinationClass);
  }

  public <T> List<T> map(List sourceList, Class<T> DestinationClass, String mapId) {
    List<T> list = new ArrayList<>();
    for (Object each : sourceList) {
      list.add(mapper.map(each, DestinationClass, mapId));
    }
    return list;
  }

  public <T> List<T> map(List sourceList, Class<T> DestinationClass) {
    List<T> list = new ArrayList<>();
    for (Object each : sourceList) {
      list.add(mapper.map(each, DestinationClass));
    }
    return list;
  }

}
