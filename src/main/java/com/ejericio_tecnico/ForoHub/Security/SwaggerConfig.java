package com.ejericio_tecnico.ForoHub.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30) 
                .select()
                .apis(RequestHandlerSelectors.basePackage("package com.ejericio_tecnico.ForoHub")) 
                .paths(PathSelectors.any())
                .build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API de Gestión de Usuarios")
                .description("Documentación del API para la gestión de usuarios")
                .version("1.0.0")
                .build();
    }
}