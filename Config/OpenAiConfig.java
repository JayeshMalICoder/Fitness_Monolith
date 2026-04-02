package com.project.fitness_monolith.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiConfig {

    @Bean
    public OpenAPI customAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Fitness Tracking API")
                        .version("1.0")
                        .description("This is the Fitness Tracking API")
                        .contact(new Contact()
                        .name("Jayesh")
                                .email("jayesh123@gmail.com"))
                );

    }

}
