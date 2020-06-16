package com.example.feignclient.controllers;

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
  public CardsController(CardClient cardClient, @Value("${account}") String account) {
    this.cardClient = cardClient;
    this.account = account;
  }

  @GetMapping("authorize")
  public AuthsResource authorize() {
    return cardClient.authorize(new AuthsResource(), account);
  }

}
