package com.adidas.products.controller;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.adidas.products.model.MetaData;
import com.adidas.products.model.PricingInformation;
import com.adidas.products.model.Product;
import com.adidas.products.model.ProductDescription;

public final class ProductValidator {

    private ProductValidator() {
    }

    /**
     * Static method to validate the product and all sub-attributes.
     * @param product - source object to be validated.
     * @return true if source is valid.
     */
    static boolean isProductValid(Product product) {
        ProductDescription prodDescription = product.getProductDescription();
        PricingInformation prodPricing = product.getPricingInformation();
        MetaData prodMetaData = product.getMetaData();

        boolean isProductDataValid = verifyProductDetails(product.getId(), product.getModelNumber(), product.getName(),
                product.getProductType());
        boolean isMetadataValid = verifyMetaData(prodMetaData);
        boolean isPricingValid = verifyPricingInfo(prodPricing);
        boolean isProdDescValid = verifyProductDescription(prodDescription);

        return isProductDataValid && isMetadataValid && isPricingValid && isProdDescValid;
    }

    /**
     * Helper method to validate product_description of the product.
     * @param prodDescription - product_description of source.
     * @return true if valid.
     */
    private static boolean verifyProductDescription(final ProductDescription prodDescription) {
        return (StringUtils.isNotEmpty(prodDescription.getTitle())
                && StringUtils.isNotEmpty(prodDescription.getSubtitle())
                && StringUtils.isNotEmpty(prodDescription.getText()));
    }

    /**
     * Helper method to validate pricing_information of the product.
     * @param prodPricing - pricing_information of source.
     * @return true if valid.
     */
    private static boolean verifyPricingInfo(final PricingInformation prodPricing) {
        return (BigDecimal.ZERO != BigDecimal.valueOf(prodPricing.getStandardPrice())
                && BigDecimal.ZERO != BigDecimal.valueOf(prodPricing.getCurrentPrice())
                && BigDecimal.ZERO != BigDecimal.valueOf(prodPricing.getStandardPriceNoVat()));
    }

    /**
     * Helper method to validate meta_data of the product.
     * @param prodMetaData - meta_data of source.
     * @return true if valid.
     */
    private static boolean verifyMetaData(final MetaData prodMetaData) {
        return (StringUtils.isNotEmpty(prodMetaData.getPageTitle())
                && StringUtils.isNotEmpty(prodMetaData.getSiteName())
                && StringUtils.isNotEmpty(prodMetaData.getDescription())
                && StringUtils.isNotEmpty(prodMetaData.getKeywords())
                && StringUtils.isNotEmpty(prodMetaData.getCanonical()));
    }

    /**
     * Helper method to validate product details.
     * @param id - id from source.
     * @param modelNumber - model_number from source.
     * @param name - name from source.
     * @param productType - product_type from source.
     * @return true if all fields are valid.
     */
    private static boolean verifyProductDetails(final String id, final String modelNumber, final String name,
            final String productType) {
        return ((StringUtils.isNotEmpty(id) && StringUtils.isAlphanumeric(id))
                && (StringUtils.isNotEmpty(modelNumber) && StringUtils.isAlphanumeric(modelNumber))
                && (StringUtils.isNotEmpty(productType) && StringUtils.isAlpha(productType))
                && (StringUtils.isNotEmpty(name) && StringUtils.isAlphaSpace(name)));
    }

}
