package com.example.parcial.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gestor de informacion Partidos API")
                        .version("1.0")
                        .description("Documentación de la API REST para el sistema informacion de partidos")
                        .contact(new Contact()
                                .name("Brayan Forigua")
                                .email("Brayanforigua13@gmail.com")
                        )
                );
    }
}