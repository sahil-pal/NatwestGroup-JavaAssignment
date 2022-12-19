package com.natwest.app;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {                                    
    
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.ant("/api/*"))                          
          .build()
          .apiInfo(apiDetails());
    }
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"RPS Service",
				"RPS Game Web Service",
				"1.0",
				"Free to Use",
				new springfox.documentation.service.Contact("sahil pal"	,"",""),
				"API License",
				"",
				Collections.emptyList()
			);
	}
}
