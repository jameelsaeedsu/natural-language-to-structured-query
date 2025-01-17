package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.service;

import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.CustomerSearchRequest;
import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.llm.Transformer;
import org.springframework.stereotype.Service;

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
    public void transformAndSendToElastic(String searchText) {
        CustomerSearchRequest customerSearchRequest = transformer.transform(searchText);
        toElastic.sendCustomerSearchRequestToElastic(customerSearchRequest);
    }

}
