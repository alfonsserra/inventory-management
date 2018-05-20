package com.systelab.inventory.config;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;

import java.util.ArrayList;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths())
                .build()
                .apiInfo(metaData())
                .tags(new Tag("Product Entity", "Product Management API"),
                        new Tag("ProductGroup Entity", "Product Group Management API"),
                        new Tag("Supplier Entity", "Supplier Management API"),
                        new Tag("Warehouse Entity", "Warehouse Management API"),
                        new Tag("Order Entity", "Order Management API"))
                .securitySchemes(Lists.newArrayList(apiKey()));
    }

    private Predicate<String> paths() {
        return or(
                regex("/application.*"),
                regex("/warehouses.*"),
                regex("/orders.*"),
                regex("/supplier.*"),
                regex("/productgroups.*"),
                regex("/products.*"));
    }

    private ApiKey apiKey() {
        return new ApiKey("Bearer", "Authorization", "header");
    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Seed application programming interface (API)",
                "Restful API to manage the Inventory Management Application.",
                "V1.0",
                "Terms of service",
                new Contact("Alfons Serra", "https://github.com/alfonsserra/", "alfonsoserra@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
        return apiInfo;
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build();
    }
}