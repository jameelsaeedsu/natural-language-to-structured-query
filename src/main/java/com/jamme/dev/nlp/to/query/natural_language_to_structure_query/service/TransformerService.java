package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.service;

import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.Customer;

import java.util.List;

public interface TransformerService {

    List<Customer> transformAndFind(String searchText);
}
