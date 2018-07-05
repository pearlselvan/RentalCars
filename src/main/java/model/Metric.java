package model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "yoymaintenancecost",
        "depreciation",
        "rentalcount"
})
public class Metric {

    @JsonProperty("yoymaintenancecost")
    private Double yoymaintenancecost;
    @JsonProperty("depreciation")
    private Double depreciation;
    @JsonProperty("rentalcount")
    private List<Rentalcount> rentalcount = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("yoymaintenancecost")
    public Double getYoymaintenancecost() {
        return yoymaintenancecost;
    }

    @JsonProperty("yoymaintenancecost")
    public void setYoymaintenancecost(Double yoymaintenancecost) {
        this.yoymaintenancecost = yoymaintenancecost;
    }

    @JsonProperty("depreciation")
    public Double getDepreciation() {
        return depreciation;
    }

    @JsonProperty("depreciation")
    public void setDepreciation(Double depreciation) {
        this.depreciation = depreciation;
    }

    @JsonProperty("rentalcount")
    public List<Rentalcount> getRentalcount() {
        return rentalcount;
    }

    @JsonProperty("rentalcount")
    public void setRentalcount(List<Rentalcount> rentalcount) {
        this.rentalcount = rentalcount;
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
