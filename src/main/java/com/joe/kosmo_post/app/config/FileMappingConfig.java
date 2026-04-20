package com.joe.kosmo_post.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class FileMappingConfig implements WebMvcConfigurer {

	
	@Value("${app.file.mapping}")
	private String url;
	
	@Value("${app.file.location}")
	private String path;
	
	 @Override
	 public void addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry registry) {
		 registry.addResourceHandler("/resources/**")
				 .addResourceLocations("classpath:/static/");
	 }
}
