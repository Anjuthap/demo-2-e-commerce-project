package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc //makes sure that the application is ready to handle web requests.
public class SwaggerConfig implements WebMvcConfigurer { //WebMvcConfig allows you to customize the configuration eg if we want to add any handler

    @Bean
    public Docket api() { //DOcket euta method ho and return the return ma vako value haru as a bean
        return new Docket(DocumentationType.SWAGGER_2).select() //docket chai swagger ko euta interface ho ani yesle chai kun endpoint chai document garne vanera vancha
                .apis(RequestHandlerSelectors.basePackage("com.example.demo")) //RewHanSE is used to handle the only controller available in the package provided
                .paths(PathSelectors.regex("/.*")) // Swagger to document all paths that match the / wala expression
                .build().apiInfo(apiInfoMetaData()); //build le docket lai finnaly return gardincha and tyo apiinfo method is used to provide additional metadata about the API, such as the title, description, version
    }

    private ApiInfo apiInfoMetaData() { //method which is used to provide the details of api

        return new ApiInfoBuilder().title("NAME OF SERVICE")
                .description("API Endpoint Decoration")
                .contact(new Contact("Dev-Team", "https://www.dev-team.com/", "dev-team@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

}