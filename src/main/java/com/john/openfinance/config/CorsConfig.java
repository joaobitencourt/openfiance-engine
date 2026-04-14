package com.john.openfinance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Aplica apenas nas rotas da nossa API
                        // Em produção, NUNCA use "*". Coloque o domínio exato do seu frontend.
                        // Exemplo: .allowedOrigins("https://meu-painel-financeiro.com.br")
                        .allowedOrigins("http://localhost:3000", "http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true) // Necessário se for usar cookies de sessão ou tokens de autenticação
                        .maxAge(3600); // Diz ao navegador para guardar essa regra de CORS em cache por 1 hora (evita requisições extras)
            }
        };
    }

}
