package br.com.kaiomuniz.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Músicas - Desenvolvida por Kaio Muniz")
                        .version("1.0")
                        .description("CRUD completo para gerenciamento de músicas.\n\n" +
                                "**Entidade Musica:** (id, titulo, artista, genero, duracao, anoLancamento)")
                        .contact(new Contact()
                                .name("Kaio Muniz")
                                .url("https://linkedin.com/in/kaiomuniz")
                                .email("kkaioribeiro@gmail.com"))
                        .termsOfService("https://github.com/KaioMuniz") // usando como referência de portfólio
                        .license(new License()
                                .name("Licença MIT")
                                .url("https://opensource.org/licenses/MIT"))
                )
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Ambiente de Desenvolvimento")
                ));
    }
}
