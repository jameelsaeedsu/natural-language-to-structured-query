package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.llm;

import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.CustomerSearchRequest;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface Transformer {

    @SystemMessage(
            """
            Your purpose is to take the user input and match the most fitting fields
            in the data transfer object. You have tools with help you do it.
            
            RULES: 
            
            1. If there is no product name then pass in null
            2. If there is no asset name then pass in null
            3. If there is nothing from the user input to extract, respond to user that they need to provide information
            
            Below is the data transfer object
                    @Getter
                    public class CustomerSearchRequest {
                    
                        private ProductFilter productFilter;
                        private AssetFilter assetFilter;
                    
                        @Getter
                        public static class ProductFilter {
                            private String productName;
                        }
                    
                        @Getter
                        public static class AssetFilter {
                            private String name;
                        }
                    
                    }
                    
                    You have tools to help you with this
            
            """
    )
    CustomerSearchRequest transformToDTO(@UserMessage String searchText);
}
