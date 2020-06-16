package com.example.feignclient.controllers;

import com.example.feignclient.feign.clients.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

  final RestClient restClient;

  @Autowired
  public VersionController(RestClient restClient) {
    this.restClient = restClient;
  }

  @GetMapping("get-version")
  public String getVersion() {
    return restClient.getVersion();
  }
}
