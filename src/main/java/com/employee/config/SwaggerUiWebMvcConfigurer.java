package com.employee.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SwaggerUiWebMvcConfigurer implements WebMvcConfigurer{
	private final String baseUrl;
	//https://keepgrowing.in/tools/how-to-set-up-spring-boot-app-documentation-with-springfox-3/
	private SwaggerUiWebMvcConfigurer(String baseUrl) {
		this.baseUrl=baseUrl;
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String baseUrl=StringUtils.trimTrailingCharacter(this.baseUrl, '/');
		registry.addResourceHandler(baseUrl+"/swagger-ui/**")
		 .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
	        .resourceChain(false);
	}
	@Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController(baseUrl + "/swagger-ui/")
	        .setViewName("forward:" + baseUrl + "/swagger-ui/index.html");
	  }
}
