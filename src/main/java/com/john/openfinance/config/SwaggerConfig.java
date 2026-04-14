package com.john.openfinance.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean // Ensina ao Spring como construir o objeto OpenAPI
    public OpenAPI openFinanceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Core Engine - Open Finance API")
                        .description("API responsável por simular a ingestão e consulta de dados do ecossistema Open Finance.")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("John"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }

}
