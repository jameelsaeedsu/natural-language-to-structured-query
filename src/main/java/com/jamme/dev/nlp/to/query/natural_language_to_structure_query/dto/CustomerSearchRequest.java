package com.jamme.dev.nlp.to.query.natural_language_to_structure_query.dto;

import lombok.Getter;
import lombok.Setter;

public class CustomerSearchRequest {

    private ProductFilter productFilter;
    private AssetFilter assetFilter;

    public ProductFilter getProductFilter() {
        return productFilter;
    }

    public void setProductFilter(ProductFilter productFilter) {
        this.productFilter = productFilter;
    }

    public AssetFilter getAssetFilter() {
        return assetFilter;
    }

    public void setAssetFilter(AssetFilter assetFilter) {
        this.assetFilter = assetFilter;
    }

    public static class ProductFilter {
        private String productName;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }
    }

    public static class AssetFilter {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
