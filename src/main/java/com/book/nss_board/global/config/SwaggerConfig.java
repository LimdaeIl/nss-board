package com.book.nss_board.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("NSS Board API")
                        .description("User / Board 간단 게시판 API 문서")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("nss-board")
                                .email("admin@nss-board.local")));
    }
}