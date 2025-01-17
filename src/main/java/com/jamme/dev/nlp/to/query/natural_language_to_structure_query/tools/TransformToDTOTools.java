package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.tools;

import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.CustomerSearchRequest;

public interface TransformToDTOTools {

    CustomerSearchRequest transformToDTO(String productName, String assetName);
}
