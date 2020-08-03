package com.mentorondemand.routing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.mentorondemand.routing.exception.JWTException;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
@EnableEurekaClient
public class RoutingApplication {

	@Autowired
	private JwtUtils jwtUtils;
	  
	public static void main(String[] args) {
		SpringApplication.run(RoutingApplication.class, args);
	}
	
	
	@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
      
        		return builder.routes()
				.route(r -> r.path("/api/search/**")
	                    .uri("lb://search-service"))
                .route(r -> r.path("/api/auth/**")
                        .uri("lb://user-service"))
                .route(r -> r.path("/api/user/**")
                        .uri("lb://user-service"))
                .route(r -> r.path("/api/admin/**")
                        .uri("lb://training-service"))
                .route(r -> r.path("/api/enroll/**")
                        .uri("lb://enrollment-service"))
                .route(r -> r.path("/api/mentor/**")
                        .uri("lb://mentor-service"))
                .build();
    }
	
	@Bean
	public GlobalFilter globalFilter() {
		return (exchange, chain) -> {
			String path = exchange.getRequest().getPath().toString();
			if(!path.contains("auth")) {
				String jwtToken = exchange.getRequest().getHeaders().get("Authorization").get(0);
				System.out.println(jwtToken);
				if(!jwtUtils.validateJwtToken(parseJwt(jwtToken)))
					throw new JWTException("Invalid Token");
			}
			
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//				System.out.print(exchange.getResponse());
//				exchange.getRequest().getBody().subscribeOn(Schedulers.single())
//		        .doOnNext(i -> System.out.println(i))
//		        .blockLast();
//				String jwt = jwtUtils.generateJwtToken(exchange.getResponse());
//				UserJWTDTO userres= new UserJWTDTO();
//				userres.setUserName(userDetails.getUsername());
//				userres.setUserRoles(roles);
//				new JwtResponse(jwt, 
//														 userDetails.getUsername(), 
//														 roles)
			}));
		};
	}
	
	@Bean
    public CorsWebFilter corsFilter() {
        return new CorsWebFilter(corsConfigurationSource());
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
        config.addAllowedMethod(HttpMethod.PUT);
        config.addAllowedMethod(HttpMethod.GET);
        config.addAllowedMethod(HttpMethod.POST);
        config.addAllowedMethod(HttpMethod.DELETE);
        config.addAllowedMethod(HttpMethod.OPTIONS);
        config.addAllowedOrigin(CorsConfiguration.ALL);
        config.addAllowedHeader(CorsConfiguration.ALL);
        source.registerCorsConfiguration("/**", config);
        return source;
    } 
	
	
	private String parseJwt(String headerAuth) {
			
			if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
				return headerAuth.substring(7, headerAuth.length());
			}
		return null;	
	}
}
