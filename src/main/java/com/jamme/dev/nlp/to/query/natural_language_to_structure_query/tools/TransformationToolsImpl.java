package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.tools;

import com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto.CustomerSearchRequest;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class TransformationToolsImpl implements TransformationTools{

    @Tool(
            name = "transformToCustomerSearchRequest",
            value = "Extract the product name, if there is one and pass it to the parameter same for the asset name." +
                    "If there is no product name then pass null, same for the asset, if no asset name pass null"
    )
    @Override
    public String transformToCustomerSearchRequest(
            @P("The name of the product")String productName,
            @P("The name of the asset that belongs inside the product") String assetName) {

        CustomerSearchRequest searchRequest = new CustomerSearchRequest();

        if (productName == null) {

            CustomerSearchRequest.AssetFilter assetFilter = new CustomerSearchRequest.AssetFilter();
            assetFilter.setName(assetName);

            searchRequest.setAssetFilter(assetFilter);
        }

        if (assetName == null) {

            CustomerSearchRequest.ProductFilter productFilter = new CustomerSearchRequest.ProductFilter();
            productFilter.setProductName(productName);

            searchRequest.setProductFilter(productFilter);

        }


        CustomerSearchRequest.ProductFilter productFilter = new CustomerSearchRequest.ProductFilter();
        productFilter.setProductName(productName);

        CustomerSearchRequest.AssetFilter assetFilter = new CustomerSearchRequest.AssetFilter();
        assetFilter.setName(assetName);



        searchRequest.setProductFilter(productFilter);
        searchRequest.setAssetFilter(assetFilter);

        return null;
    }
}
