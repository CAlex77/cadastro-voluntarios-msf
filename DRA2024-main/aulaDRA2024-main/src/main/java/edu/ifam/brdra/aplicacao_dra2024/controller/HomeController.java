package edu.ifam.brdra.aplicacao_dra2024.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping
    public String iniciar(){
        return "Testando minha aplicação spring boot com localhost 8080";
    }
}
