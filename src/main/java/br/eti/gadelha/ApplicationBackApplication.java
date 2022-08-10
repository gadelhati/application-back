package br.eti.gadelha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@SpringBootApplication
public class ApplicationBackApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationBackApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(ApplicationBackApplication.class, args);
	}
	@Bean
	public ErrorAttributes errorAttributes() {
		return new DefaultErrorAttributes() {

			@Override
			public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions includeStackTrace) {

				Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
				errorAttributes.remove("message");
				errorAttributes.remove("timestamp");
				errorAttributes.remove("path");
				errorAttributes.get("errors");
				return errorAttributes;
			}

		};
	}
}