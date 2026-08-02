package dio.web.api.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private Contact contact() {
        return new Contact()
                .name("Seu nome")
                .url("https://www.seusite.com.br")
                .email("voce@seusite.com.br");
    }

    @Bean
    public OpenAPI informacoesApi() {
        OpenAPI openAPI = new OpenAPI();
        openAPI.info(new Info()
                        .title("Title - Rest API")
                        .description("API exemplo de uso e Spring Boot REST API")
                        .version("1.0")
                        .termsOfService("Termo de uso: Open Source")
                        .license(new License()
                                .name("Licença - Sua Empresa")
                                .url("http://www.seusite.com.br"))
                        .contact(this.contact()));

        return openAPI;
    }

    @Bean
    public GroupedOpenApi detalheApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("dio.web.api.controller")
                .pathsToMatch("/**")
                .build();
    }

}
