package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.llm;

import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.CustomerSearchRequest;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface Transformer {

    @SystemMessage(
            """
            Your purpose is to take the user input and match the most fitting fields
            in the data transfer object. You have tools with help you do it.
            """
    )
    CustomerSearchRequest transform(@UserMessage String searchText);
}
