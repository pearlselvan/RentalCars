package model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Price",
        "Discount"
})
public class Perdayrent {

    @JsonProperty("Price")
    private Integer price;
    @JsonProperty("Discount")
    private Integer discount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("Discount")
    public Integer getDiscount() {
        return discount;
    }

    @JsonProperty("Discount")
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}