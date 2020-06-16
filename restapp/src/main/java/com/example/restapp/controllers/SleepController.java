package com.example.restapp.controllers;

import com.example.restapp.resources.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class SleepController {

  private final String instanceId;

  public SleepController(@Value("${eureka.instance.instance-id}") String instanceId) {
    this.instanceId = instanceId;
  }

  @GetMapping("slow-greeting")
  public Greeting slowGreeting(@RequestParam("delay") Long delay) throws InterruptedException {
    System.out.println("Calling: " + instanceId);
    TimeUnit.SECONDS.sleep(delay);
    return new Greeting(instanceId, delay);
  }
}
