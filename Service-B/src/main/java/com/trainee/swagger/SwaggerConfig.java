package com.trainee.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.trainee"))
        .paths(regex("/v1.*")).build().apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    ApiInfo apiInfo = new ApiInfo("Proyecto Everis", "Restful - CRUD básico", "1.0", "Terms of service",
        new Contact("Alexander Escalante", "", "adescalantes@company.com"), "License of API", "API license URL");
    return apiInfo;
  }
}
