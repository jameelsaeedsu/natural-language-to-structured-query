package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto;

import lombok.Getter;

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
