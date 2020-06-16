package com.example.feignclient.feign.clients;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.feignclient.feign.resources.AuthsResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "card", url = "${base_url}")
public interface CardClient {

  @PostMapping(
      value = "/cardpayments/v1/accounts/{account}/auths",
      consumes = APPLICATION_JSON_VALUE,
      produces = APPLICATION_JSON_VALUE)
  AuthsResource authorize(@RequestBody AuthsResource request, @PathVariable("account") String account);
}
