package com.employee.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Bean;

@Configuration
public class SwaggerUiConfig {
	
	@Bean
	public Docket employeeApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.apis())
				//.paths(null)
				.paths(regex("/employee"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
        .title("Employee API")
        .description("Employee is a web application designed for project management")
        .license("Shiv gupta")
        .licenseUrl("shivgupta864@gmail.com")
        .build();
	}

	private Predicate<String> regex(String urlPath) {
		//string.
		return Pattern.compile(urlPath).asPredicate();
	}
}
