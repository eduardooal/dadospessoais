package br.senac.tads.dsw.dadospessoais;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tools.jackson.databind.json.JsonMapper;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Mensagem hello() {
        return new Mensagem("Eduardo Alcantara de Souza", "Olá, mundo! Meu primeiro endpoint Spring Boot.");
    }

    @GetMapping(value = "/hello-manual", produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloManual() {
        Mensagem mensagem = new Mensagem("Eduardo Alcantara de Souza", "JSON gerado manualmente com ObjectMapper.");
        JsonMapper mapper = new JsonMapper();
        return mapper.writeValueAsString(mensagem);
    }
}