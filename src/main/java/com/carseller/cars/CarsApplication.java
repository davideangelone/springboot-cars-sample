package com.carseller.cars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableConfigurationProperties
@EnableScheduling
@Slf4j
@OpenAPIDefinition(
        info = @Info(title = "Cars Api Application", version = "1.0.0")
)
public class CarsApplication {

  public static void main(String[] args) {
    SpringApplication.run(CarsApplication.class, args);

	log.info(">>> Json specs at : /v3/api-docs <<<");
	log.info(">>> Yaml specs at : /v3/api-docs.yaml <<<");
	log.info(">>> Swagger at : /swagger-ui.html <<<");
	log.info(">>> Frontend at: /index.html <<<");
  }

}
