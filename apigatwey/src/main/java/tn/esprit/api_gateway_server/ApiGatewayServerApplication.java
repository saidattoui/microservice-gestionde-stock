package tn.esprit.api_gateway_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayServerApplication.class, args);
    }
/*
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("stockMs", r -> r.path("/stock/**").uri("http://localhost:8091"))
                .route("produitMs", r -> r.path("/produits/**").uri("http://localhost:8479"))
                .route("fournisseurMs", r -> r.path("/fournisseurs/**").uri("http://localhost:8088"))
                .route("commandeMs", r -> r.path("/commandes/**").uri("http://localhost:8082"))
                .build();
    }

 */

}
