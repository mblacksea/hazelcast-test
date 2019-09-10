package com.mblacksea.hazelcasttest.config;

import com.mblacksea.hazelcasttest.mapper.DozzerMapperUtility;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DozerConfig {

  @Bean
  public List<ClassPathResource> dozerMapFiles() {
    List<ClassPathResource> classPathResources = new ArrayList<>();
    classPathResources.add(new ClassPathResource("/dozer/dozer-dtos.xml"));
    return classPathResources;
  }

  @Bean
  public DozzerMapperUtility dozerMapperUtility(Mapper mapper) {
    DozzerMapperUtility dozzerMapperUtility = new DozzerMapperUtility();
    dozzerMapperUtility.setMapper(mapper);
    return dozzerMapperUtility;
  }

  @Bean
  public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean(List<ClassPathResource> classPathResources) {
    DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
    Resource[] resources = new Resource[classPathResources.size()];
    classPathResources.toArray(resources);
    dozerBeanMapperFactoryBean.setMappingFiles(resources);
    return dozerBeanMapperFactoryBean;
  }


}
