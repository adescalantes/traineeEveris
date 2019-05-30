package com.trainee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TestApplication {

  /**
   * <h1>Proyecto Restful</h1>
   * 
   * @param args arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(TestApplication.class, args);
  }

}
