package edu.ifam.brdra.aplicacao_dra2024.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Voluntario - Aplicação DRA 2024")
                        .version("1.0.0")
                        .description("Documentação da API para gerenciar voluntarios no BD DRA AVALIAÇÃO"));
    }
}
