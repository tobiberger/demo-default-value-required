package com.example.demodefaultvaluerequired.demodefaultvaluerequired

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfiguration {

    @Bean
    fun api(): GroupedOpenApi = GroupedOpenApi
        .builder()
        .group("api")
        .pathsToMatch("/**")
        .build()
}
