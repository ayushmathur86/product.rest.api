package com.adidas.products.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Class to represent the product.
 *
 */
@JsonSerialize
@JsonPropertyOrder({ "id", "name", "model_number", "product_type", "meta_data", "pricing_information",
        "product_description" })
public class Product {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("model_number")
    private String modelNumber;

    @JsonProperty("product_type")
    private String productType;

    @JsonProperty("meta_data")
    private MetaData metaData;

    @JsonProperty("pricing_information")
    private PricingInformation pricingInformation;

    @JsonProperty("product_description")
    private ProductDescription productDescription;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("model_number")
    public String getModelNumber() {
        return modelNumber;
    }

    @JsonProperty("model_number")
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    @JsonProperty("product_type")
    public String getProductType() {
        return productType;
    }

    @JsonProperty("product_type")
    public void setProductType(String productType) {
        this.productType = productType;
    }

    @JsonProperty("meta_data")
    public MetaData getMetaData() {
        return metaData;
    }

    @JsonProperty("meta_data")
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    @JsonProperty("pricing_information")
    public PricingInformation getPricingInformation() {
        return pricingInformation;
    }

    @JsonProperty("pricing_information")
    public void setPricingInformation(PricingInformation pricingInformation) {
        this.pricingInformation = pricingInformation;
    }

    @JsonProperty("product_description")
    public ProductDescription getProductDescription() {
        return productDescription;
    }

    @JsonProperty("product_description")
    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return String.format("{ Product=%s }", id, name, modelNumber, productType, metaData, pricingInformation,
                productDescription);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(productDescription).append(pricingInformation).append(name)
                .append(metaData).append(modelNumber).append(productType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Product) == false) {
            return false;
        }
        Product rhs = ((Product) other);
        return new EqualsBuilder().append(id, rhs.id).append(productDescription, rhs.productDescription)
                .append(pricingInformation, rhs.pricingInformation).append(name, rhs.name)
                .append(metaData, rhs.metaData).append(modelNumber, rhs.modelNumber)
                .append(productType, rhs.productType).isEquals();
    }

}