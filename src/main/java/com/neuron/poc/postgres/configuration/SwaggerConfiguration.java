package com.neuron.poc.postgres.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

  @Bean
  public OpenApiCustomizer removeDeleteOperations() {
    return openApi -> openApi.getPaths().values().forEach(pathItem ->
        pathItem.setDelete(null)
    );
  }

}
