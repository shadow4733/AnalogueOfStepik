package com.course_management_service.config

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun customOpenApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("user-management-api")
            .packagesToScan("com.course_management_service")
            .build()
    }
}