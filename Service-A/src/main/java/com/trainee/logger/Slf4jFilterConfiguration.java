package com.trainee.logger;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "logger.slf4jfilter")
public class Slf4jFilterConfiguration {

  public static final String DEFAULT_RESPONSE_TOKEN_HEADER = "Response_Token";
  public static final String DEFAULT_MDC_UUID_TOKEN_KEY = "Slf4jMDCFilter.UUID";
  public static final String DEFAULT_MDC_CLIENT_IP_KEY = "Slf4jMDCFilter.ClientIP";

  private String responseHeader = DEFAULT_RESPONSE_TOKEN_HEADER;
  private String mdcTokenKey = DEFAULT_MDC_UUID_TOKEN_KEY;
  private String mdcClientIpKey = DEFAULT_MDC_CLIENT_IP_KEY;
  private String requestHeader = null;

}