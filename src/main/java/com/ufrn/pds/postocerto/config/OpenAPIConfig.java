package com.ufrn.pds.postocerto.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
@Bean
public OpenAPI postocertoOpenAPI() {
    return new OpenAPI()
            .info(new Info().title("Postocerto API")
                    .description("PostoCerto - Uma plataforma que facilita o encontro de melhores postos de combustíveis")
                    .version("v0.0.1")
                    .license(new License().name("Apache 2.0").url("http://springdoc.org")))
            .externalDocs(new ExternalDocumentation()
                    .description("Repositorio do projeto")
                    .url("https://github.com/AndreLiberato/PostoCerto"));
}


}