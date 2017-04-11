package com.keeper.config;


import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Alexandr Vasiliev on 06.04.2017.
 *
 * @author Alexandr Vasiliev
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    List<Parameter> listParameter = new ArrayList<>();
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
//                .globalOperationParameters(listParameter)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("some service")
                .description("description")
                .build();
    }
}