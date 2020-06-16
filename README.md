# feign-demo

## Projects

### 1. eureka
The Eureka Server project, where all other projects are deployed

### 2. restapp
Rest application which we will consume

### 3. feignclient - ymlConfig
Feign client, configured with application.yml

### 4. feignclient-beanconfig
Feign client, configured with configuration file

### 5. feignclient-beanconfig - oldschool
Feign client, configured with configuration file and FeignBuilder - the old school way

## Requirements
1. Java 8
2. Gradle 5.6.4 +
3. Gradle wrapper is not configured, so use external Gradle

## Run
Just use `gradle bootRun` or start through IntelliJ

## External Resources
1. Spring cloud documentation: https://cloud.spring.io/spring-cloud-openfeign/multi/multi_spring-cloud-feign.html
2. OpenFeign repository: https://github.com/OpenFeign/feign