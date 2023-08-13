package br.com.otavio.restwithspringbootandjavaerudio.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Curso: Desenvolva uma API REST do 0")
                        .version("v1")
                        .description("Curso dedicado aos estudos complementares do dev Otávio")
                        .termsOfService("")
                        .license(new License().name("Itaú").url("https://itau.com.br"))
                        );
    }

}
