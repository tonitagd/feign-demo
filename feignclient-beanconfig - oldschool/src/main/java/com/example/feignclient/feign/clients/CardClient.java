package com.example.feignclient.feign.clients;

import com.example.feignclient.config.CardsConfiguration;
import com.example.feignclient.feign.resources.AuthsResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.core.MediaType;

@FeignClient(name = "card", url="${base_url}", configuration = CardsConfiguration.class)
public interface CardClient {

  @PostMapping(value = "/cardpayments/v1/accounts/{account}/auths", consumes = MediaType.APPLICATION_JSON)
  AuthsResource authorize(@RequestBody AuthsResource request, @RequestParam("account") String account);
}
