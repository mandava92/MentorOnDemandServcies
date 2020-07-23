package com.mentorondemand.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;
@EnableEurekaClient
@SpringBootApplication
public class RoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutingApplication.class, args);
	}
	
	@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		System.out.println("hello");
      
        		return builder.routes()
                        .route(r -> r.path("/api/auth/**").uri("lb://user-service"))
                        .build();       		
//                .route(r -> r.path("/api/user/**")
//                        .uri("lb://user-service/"))
//                .route(r -> r.path("/api/admin/**")
//                        .uri("lb://admin-service/"))
//                .route(r -> r.path("/api/studenttraining/**")
//                        .uri("lb://student-service/"))
//                .route(r -> r.path("/api/mentor/**")
//                        .uri("lb://mentor-service/"))
              //  .build();
    }
	
	@Bean
	public ServerCodecConfigurer serverCodecConfigurer() {
	   return ServerCodecConfigurer.create();
	}

}
