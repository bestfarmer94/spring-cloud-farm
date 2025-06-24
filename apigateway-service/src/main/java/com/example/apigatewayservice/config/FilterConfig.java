package com.example.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

//@Configuration
public class FilterConfig {
    Environment env;

    public FilterConfig(Environment env) {
        this.env = env;
    }

//    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/first-service/**")
                        .filters(f -> f
                                .addRequestHeader("f-request", "First Service Request")
                                .addResponseHeader("f-response", "First Service Response"))
                        .uri("http://localhost:8081"))
                .route(r -> r.path("/second-service/**")
                        .filters(f -> f
                                .addRequestHeader("s-request", "Second Service Request")
                                .addResponseHeader("s-response", "Second Service Response"))
                        .uri("http://localhost:8082"))
                .build();
    }
}
