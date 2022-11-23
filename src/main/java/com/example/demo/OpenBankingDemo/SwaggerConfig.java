package com.example.demo.OpenBankingDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/api/v1.*"), regex("/accounts/*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Open Banking API")
                .description("Open Banking API reference for developers")
                .termsOfServiceUrl("http://ashishbania.com")
                .contact("ashish.bania@gmail.com").license("Open License")
                .licenseUrl("ashish.bania@gmail.com").version("1.0").build();
    }

}