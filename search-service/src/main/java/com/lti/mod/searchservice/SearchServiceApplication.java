package com.lti.mod.searchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.ElasticsearchVersion;
import io.searchbox.client.config.HttpClientConfig;

@SpringBootApplication
@EnableDiscoveryClient
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

}
