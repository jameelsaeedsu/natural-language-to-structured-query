package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.service;

import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.CustomerSearchRequest;

public interface SearchRequestToElasticService {

    void sendCustomerSearchRequestToElastic(CustomerSearchRequest searchRequest);
}
