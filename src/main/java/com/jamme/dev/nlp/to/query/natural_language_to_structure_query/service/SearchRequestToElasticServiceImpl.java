package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.service;

import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.Customer;
import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.CustomerSearchRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SearchRequestToElasticServiceImpl implements SearchRequestToElasticService{

    private final RestTemplate restTemplate;

    public SearchRequestToElasticServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Customer> findCustomerBasedOnRequest(CustomerSearchRequest searchRequest) {

        String url = "http://localhost:8081/api/v1/customer/search";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CustomerSearchRequest> requestHttpEntity = new HttpEntity<>(searchRequest, headers);

        ResponseEntity<List<Customer>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestHttpEntity,
                new ParameterizedTypeReference<>() {}
        );

        return response.getBody();
    }
}
