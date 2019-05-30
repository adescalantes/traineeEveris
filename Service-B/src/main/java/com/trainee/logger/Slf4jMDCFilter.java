package com.trainee.logger;

import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The class that configures a servlet that adds a key to the Mapped Diagnostic
 * Context (MDC) to each request so you can print a unique id in the logg
 * messages of each request. It also add the key as a header in the response so
 * the caller of the request can provide you the id to browse the logs. Set the
 * response header name to null/blank if you want the response to NOT include
 * such header.
 * 
 * If you provide a request header name, the filter will check first if the
 * request contains a header with that name and will use the ID it provides.
 * This is useful if your application chain has already assigned an id to the
 * "transaction". (Microservices, apps behind a proxy/gateway service...)
 * 
 * The MDC key and the header names are configurable.
 * 
 * Here's a configuration sample with the default values:
 * 
 * <pre>
 * summer:
 *   slf4jfilter:
 *     response_header: Response_Token
 *     mdc_token_key: Slf4jMDCFilter.UUID
 *     mdc_client_ip_key: Slf4jMDCFilter.ClientIP
 *     request_header:
 * </pre>
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class Slf4jMDCFilter extends OncePerRequestFilter {

  private final String responseHeader;
  private final String mdcTokenKey;
  private final String mdcClientIpKey;
  private final String requestHeader;

  public Slf4jMDCFilter() {
    responseHeader = Slf4jFilterConfiguration.DEFAULT_RESPONSE_TOKEN_HEADER;
    mdcTokenKey = Slf4jFilterConfiguration.DEFAULT_MDC_UUID_TOKEN_KEY;
    mdcClientIpKey = Slf4jFilterConfiguration.DEFAULT_MDC_CLIENT_IP_KEY;
    requestHeader = null;
  }

  public Slf4jMDCFilter(final String responseHeader, final String mdcTokenKey, final String mdcClientIPKey, final String requestHeader) {
    this.responseHeader = responseHeader;
    this.mdcTokenKey = mdcTokenKey;
    this.mdcClientIpKey = mdcClientIPKey;
    this.requestHeader = requestHeader;
  }

  @Override
  protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
      final FilterChain chain) throws java.io.IOException, ServletException {
    try {
      final String token = extractToken(request);
      final String clientIP = extractClientIP(request);
      MDC.put(mdcClientIpKey, clientIP);
      MDC.put(mdcTokenKey, token);
      if (!StringUtils.isEmpty(responseHeader)) {
        response.addHeader(responseHeader, token);
      }
      chain.doFilter(request, response);
    } finally {
      MDC.remove(mdcTokenKey);
      MDC.remove(mdcClientIpKey);
    }
  }

  private String extractToken(final HttpServletRequest request) {
    final String token;
    if (!StringUtils.isEmpty(requestHeader) && !StringUtils.isEmpty(request.getHeader(requestHeader))) {
      token = request.getHeader(requestHeader);
    } else {
      token = UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }
    return token;
  }

  private String extractClientIP(final HttpServletRequest request) {
    final String clientIP;
    if (request.getHeader("X-Forwarded-For") != null) {
      clientIP = request.getHeader("X-Forwarded-For").split(",")[0];
    } else {
      clientIP = request.getRemoteAddr();
    }
    return clientIP;
  }

  @Override
  protected boolean isAsyncDispatch(final HttpServletRequest request) {
    return false;
  }

  @Override
  protected boolean shouldNotFilterErrorDispatch() {
    return false;
  }
}