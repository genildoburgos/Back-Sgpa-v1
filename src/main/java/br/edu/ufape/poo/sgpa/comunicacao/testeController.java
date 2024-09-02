package br.edu.ufape.poo.sgpa.comunicacao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class testeController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
