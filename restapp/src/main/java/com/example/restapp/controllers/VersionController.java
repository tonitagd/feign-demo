package com.example.restapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

  @GetMapping("/version")
  public String getVersion() {
    System.out.println("Calling version controller...");
    return "\"version\": \"1.0.0\"";
  }
}
