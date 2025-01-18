package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.service;

import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.Customer;
import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.CustomerSearchRequest;

import java.util.List;

public interface SearchRequestToElasticService {

    List<Customer> findCustomerBasedOnRequest(CustomerSearchRequest searchRequest);
}
