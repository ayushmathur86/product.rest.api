package com.adidas.products.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Class to represent product_description of the product.
 *
 */
@JsonSerialize
@JsonPropertyOrder({ "title", "subtitle", "text" })
public class ProductDescription {

    @JsonProperty("title")
    private String title;

    @JsonProperty("subtitle")
    private String subtitle;

    @JsonProperty("text")
    private String text;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("subtitle")
    public String getSubtitle() {
        return subtitle;
    }

    @JsonProperty("subtitle")
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("{ ProductDescription=%s }", title, subtitle, text);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(text).append(title).append(subtitle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductDescription) == false) {
            return false;
        }
        ProductDescription rhs = ((ProductDescription) other);
        return new EqualsBuilder().append(text, rhs.text).append(title, rhs.title).append(subtitle, rhs.subtitle)
                .isEquals();
    }

}