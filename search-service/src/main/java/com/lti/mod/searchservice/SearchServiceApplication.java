package com.lti.mod.searchservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.ElasticsearchVersion;
import io.searchbox.client.config.HttpClientConfig;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class SearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchServiceApplication.class, args);
	}
	
	@Bean
	public JestClient jestClient() {
	    JestClientFactory factory = new JestClientFactory();
	    factory.setHttpClientConfig(
	      new HttpClientConfig.Builder("http://localhost:9200")
	        .multiThreaded(true)
	        .defaultMaxTotalConnectionPerRoute(2)
	        .maxTotalConnection(10)
	        .build());
	    return factory.getObject();
	}

	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.lti.mod.searchservice.controller"))
//	      .paths(PathSelectors.ant("/api/*"))
//	      .apis(RequestHandlerSelectors.any())              
//          .paths(PathSelectors.any())      
	      .build()
	      .apiInfo(apiInfo());
	}
	 
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Search Service API", 
	      "Search & Recs", 
	      "Mentor On demand", 
	      null, 
//	      new Contact("Prasenjit Choudhury", "http://localhost:4200", "prasenjitc29@gmail.com"),
	      null,
	      "2020", "None", Collections.emptyList());
	}
}
