package com.example.feignclient.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.feignclient.feign.clients.CardClient;
import com.example.feignclient.feign.resources.AuthsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

  final CardClient cardClient;

  final String account;

  @Autowired
  public CardsController(@Value("${account}") String account, CardClient cardClient) {
    this.account = account;
    this.cardClient = cardClient;
  }

  @GetMapping(value = "authorize")
  public AuthsResource authorize() {
    return cardClient.authorize(new AuthsResource(), account);
  }
}
