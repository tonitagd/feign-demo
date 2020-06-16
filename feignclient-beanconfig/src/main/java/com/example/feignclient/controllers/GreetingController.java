package com.example.feignclient.controllers;

import com.example.feignclient.feign.clients.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  final RestClient restClient;

  @Autowired
  public GreetingController(RestClient restClient) {
    this.restClient = restClient;
  }

  @GetMapping("slow-greeting")
  public Object slowGreeting(@RequestParam("delay") Long delay) {
    return restClient.getSlowGreeting(delay);
  }
}
