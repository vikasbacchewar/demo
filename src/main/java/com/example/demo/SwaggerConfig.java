package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

/**
 * Swagger Configuration with Spring boot
 * 
 * @author vikasbacchewar
 * @version 1.0
 * @since 2019-12-30
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String SITE_URL = "http://vikas-bacchewar.com";
	@Bean
	public Docket postsApi() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")		// Optional
				.apiInfo(apiInfo())				// Swagger project information
				.select()
				.paths(postPaths())				// Swagger configured paths
				.build();
	}

	/**
	 *  Bind API for swagger documentation
	 * 	@return
	 */
	private Predicate<String> postPaths() {
		return or(regex("/*"), regex("/*"));
	}

	/**
	 * Swagger Project and Author information
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().
				title("SpringBoot Swagger POC")
				.description("SpringBoot Swagger POC API reference for developers")
				.termsOfServiceUrl(SITE_URL)
				.contact(new Contact("vikas bacchewar", SITE_URL,
						"vikas.bacchewar@gmail.com"))
				.license("FREE License")
				.licenseUrl(SITE_URL)
				.version("1.0")
				.build();
	}

}