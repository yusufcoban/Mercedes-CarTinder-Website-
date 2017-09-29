//package com.example;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//@EnableWebMvc
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/add")
//			.allowedOrigins("http://localhost:8080")
//			.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
//			.allowedHeaders("header1", "header2", "header3")
//			.exposedHeaders("header1", "header2")
//			.allowCredentials(false).maxAge(3600);
//		registry.addMapping("/data2")
//		.allowedOrigins("http://localhost:8080")
//		.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
//		.allowedHeaders("header1", "header2", "header3")
//		.exposedHeaders("header1", "header2")
//		.allowCredentials(false).maxAge(3600);
//		registry.addMapping("/data4")
//		.allowedOrigins("http://localhost:8080")
//		.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
//		.allowedHeaders("header1", "header2", "header3")
//		.exposedHeaders("header1", "header2")
//		.allowCredentials(false).maxAge(3600);
//		registry.addMapping("/add")
//		.allowedOrigins("http://localhost:8080")
//		.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
//		.allowedHeaders("header1", "header2", "header3")
//		.exposedHeaders("header1", "header2")
//		.allowCredentials(false).maxAge(3600);
//	}
//}