package br.edu.ufape.poo.sgpa.controller.dto;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@Tag(name="academia", description = "text")
public class testeController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
