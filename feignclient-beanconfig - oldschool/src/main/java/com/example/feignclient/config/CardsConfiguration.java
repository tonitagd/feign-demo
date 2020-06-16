package com.example.feignclient.config;

import com.example.feignclient.feign.clients.CardClient;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

public class CardsConfiguration {

  @Value("${base_url}")
  private String baseUrl;

  @Value("${user}")
  private String user;

  @Value("${password}")
  private String password;

  @Bean
  public RequestInterceptor basicAuthRequestInterceptor() {
    return new BasicAuthRequestInterceptor(user, password);
  }

  @Bean
  public CardClient cardClient() {
    return new Feign.Builder()
        .decoder(new JacksonDecoder())
        .encoder(new JacksonEncoder())
        .contract(new SpringMvcContract())
        .logger(new Slf4jLogger(CardClient.class))
        .logLevel(Logger.Level.FULL)
        .options(new Request.Options(10000, TimeUnit.MICROSECONDS, 10000, TimeUnit.MICROSECONDS, true))
//        .requestInterceptor(new BasicAuthRequestInterceptor(user, password)) Does not work in 10.x for some reason
        .target(CardClient.class, baseUrl);
  }
}
