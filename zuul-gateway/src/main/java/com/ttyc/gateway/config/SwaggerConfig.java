package com.ttyc.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    @Primary
    public SwaggerResourcesProvider swaggerResourcesProvider(){
        return new DocumentationConfig();
    }

    class DocumentationConfig implements SwaggerResourcesProvider {
        @Override
        public List<SwaggerResource> get() {
            List<SwaggerResource> resources = new ArrayList<>();
            resources.add(swaggerResource("swagger-consumer-feign", "/consumer-api/v2/api-docs"));
            resources.add(swaggerResource("swagger-consumer-ribbon", "/consumer-ribbon/v2/api-docs"));
            return resources;
        }

        private SwaggerResource swaggerResource(String name, String location) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion("2.0");
            return swaggerResource;
        }
    }
}
