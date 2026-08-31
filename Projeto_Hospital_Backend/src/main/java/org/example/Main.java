package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        // Este comando liga o servidor Tomcat na porta 8080 do teu PC
        SpringApplication.run(Main.class, args);
        System.out.println(" SERVIDOR DO HOSPITAL LIGADO COM SUCESSO NA PORTA 8080!");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
