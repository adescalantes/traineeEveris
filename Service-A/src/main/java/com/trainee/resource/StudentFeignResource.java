package com.trainee.resource;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trainee.configuration.FeignClientConfiguration;

@FeignClient(name = "service-b", configuration = FeignClientConfiguration.class, url = "https://localhost:8444/")
public interface StudentFeignResource {

  @RequestMapping(value = "/v1/students/list", method = RequestMethod.POST)
  public List<Object> getStudentsById(@RequestBody List<Integer> id);
}
