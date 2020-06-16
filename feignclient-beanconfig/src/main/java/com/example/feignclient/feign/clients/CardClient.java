package com.example.feignclient.feign.clients;

import com.example.feignclient.config.CardsConfiguration;
import com.example.feignclient.feign.resources.AuthsResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "card", url = "${base_url}", configuration = CardsConfiguration.class)
public interface CardClient {

  @PostMapping(value = "/cardpayments/v1/accounts/{account}/auths",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  AuthsResource authorize(@RequestBody AuthsResource request, @PathVariable("account") String account);
}
