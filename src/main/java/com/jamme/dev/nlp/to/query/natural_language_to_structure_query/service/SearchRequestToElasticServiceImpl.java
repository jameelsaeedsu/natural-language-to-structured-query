package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.service;

import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.CustomerSearchRequest;
import org.springframework.stereotype.Service;

@Service
public class SearchRequestToElasticServiceImpl implements SearchRequestToElasticService{


    @Override
    public void sendCustomerSearchRequestToElastic(CustomerSearchRequest searchRequest) {
        //Make Post request and send the CustomerSearchRequest
    }
}
