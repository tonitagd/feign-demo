package com.example.restapp.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Greeting {
  @JsonProperty
  private String instanceId;
  @JsonProperty
  private Long delay;
  @JsonProperty
  private String greeting;

  public Greeting(String instanceId, Long delay) {
    this.instanceId = instanceId;
    this.delay = delay;
    this.greeting = "Hello!";
  }
}
