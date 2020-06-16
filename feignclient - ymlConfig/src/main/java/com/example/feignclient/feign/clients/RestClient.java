package com.example.feignclient.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("restapp")
public interface RestClient {

  @GetMapping("version")
  String getVersion();

  @GetMapping("slow-greeting")
  Object getSlowGreeting(@RequestParam("delay") Long delay);
}
