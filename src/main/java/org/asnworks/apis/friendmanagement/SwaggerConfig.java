/**
 * 
 */
package org.asnworks.apis.friendmanagement;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sudambat Swagger API Configuration
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * @return Docket
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors
                .basePackage("org.asnworks.apis.friendmanagement.rest"))
            .paths(regex("/firendsapi.*")).build()
            .apiInfo(metaData());
    }

    /**
     * @return APIInfo
     */
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo("Friend Management System",
            "REST Api", "1.0",
            "Terms & Conditions", new Contact("Sudarshan", "", "sudarsan.a@icloud.com"), "", "");
        return apiInfo;
    }

}
