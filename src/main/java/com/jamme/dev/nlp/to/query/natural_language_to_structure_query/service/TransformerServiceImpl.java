package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.service;

import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.Customer;
import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.CustomerSearchRequest;
import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.llm.Transformer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransformerServiceImpl implements TransformerService{

    private final Transformer transformer;
    private final SearchRequestToElasticService toElastic;

    public TransformerServiceImpl(Transformer transformer,
                                  SearchRequestToElasticService toElastic) {
        this.transformer = transformer;
        this.toElastic = toElastic;
    }

    @Override
    public List<Customer> transformAndFind(String searchText) {
        CustomerSearchRequest customerSearchRequest = transformer.transformToDTO(searchText);
        return toElastic.findCustomerBasedOnRequest(customerSearchRequest);
    }

}
