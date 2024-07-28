package com.lcwd.electronic.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .securityContexts(Collections.singletonList(getSecurityContext()))
                .securitySchemes(Collections.singletonList(getSchemes()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private SecurityContext getSecurityContext() {
        return SecurityContext.builder()
                .securityReferences(getSecurityReferences())
                .build();
    }

    private List<SecurityReference> getSecurityReferences() {
        AuthorizationScope[] scopes = {new AuthorizationScope("Global", "Access Everything")};
        return Collections.singletonList(new SecurityReference("JWT", scopes));
    }

    private ApiKey getSchemes() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Electronic Store Backend : APIS",
                "Made by KRITIKA DAS",
                "1.0.0V",
                "Terms of service",
                new Contact("Kritika Das", "www.linkedin.com/in/kritika-das-3040b2246", "kritika@example.com"),
                "License of API",
                "API license URL",
                Collections.emptyList()
        );
    }
}
