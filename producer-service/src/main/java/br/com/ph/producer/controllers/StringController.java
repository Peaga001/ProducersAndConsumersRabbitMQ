package br.com.ph.producer.controllers;

import br.com.ph.producer.services.StringService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produces")

public class StringController {
    private final StringService $service;

    public StringController(StringService $service) {
        this.$service = $service;
    }

    @GetMapping
    public ResponseEntity<String> produces(@RequestParam("message") String $message)
    {
        $service.produce($message);
        return ResponseEntity.ok().body("Sending message");
    }
}
