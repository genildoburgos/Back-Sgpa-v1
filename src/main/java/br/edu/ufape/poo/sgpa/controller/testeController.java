package br.edu.ufape.poo.sgpa.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@Tag(name="academia", description = "text")
public class testeController {

    @GetMapping("/hello")
    @ApiResponse(responseCode = "200")
    public String hello() {
        return "Hello World";
    }
}
