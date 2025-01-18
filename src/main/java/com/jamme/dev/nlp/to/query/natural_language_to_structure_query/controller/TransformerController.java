package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.controller;

import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.Customer;
import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.service.TransformerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransformerController {

    private final TransformerService transformerService;

    public TransformerController(TransformerService transformerService) {
        this.transformerService = transformerService;
    }

    @PostMapping("/search-natural-language")
    public ResponseEntity<List<Customer>> transformAndSendToElastic(@RequestParam String searchText) {
        // customers with product name, ISK Konto and stock called "Tesla"
        List<Customer> customers = transformerService.transformAndFind(searchText);
        return ResponseEntity.ok(customers);
    }
}
