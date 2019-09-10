package com.mblacksea.hazelcasttest;

import com.mblacksea.hazelcasttest.mapper.DozzerMapperUtility;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HazelcastTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(HazelcastTestApplication.class, args);
  }

}
