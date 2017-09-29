
package entity;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxTrunkCapacity",
    "doors",
    "efficiencyClass",
    "driveConcept",
    "ratedOutputKw",
    "basePrice_eur",
    "generalColor",
    "minTrunkCapacity",
    "color",
    "engineConcept",
    "fuelTypePrimary",
    "seats",
    "fuelConsumptionCombinedMin",
    "fuelConsumptionCombinedMax"
})
public class TechnicalValues {

    @JsonProperty("maxTrunkCapacity")
    private Integer maxTrunkCapacity;
    @JsonProperty("doors")
    private Integer doors;
    @JsonProperty("efficiencyClass")
    private String efficiencyClass;
    @JsonProperty("driveConcept")
    private String driveConcept;
    @JsonProperty("ratedOutputKw")
    private Integer ratedOutputKw;
    @JsonProperty("basePrice_eur")
    private Double basePriceEur;
    @JsonProperty("generalColor")
    private String generalColor;
    @JsonProperty("minTrunkCapacity")
    private Integer minTrunkCapacity;
    @JsonProperty("color")
    private String color;
    @JsonProperty("engineConcept")
    private String engineConcept;
    @JsonProperty("fuelTypePrimary")
    private String fuelTypePrimary;
    @JsonProperty("seats")
    private Integer seats;
    @JsonProperty("fuelConsumptionCombinedMin")
    private Double fuelConsumptionCombinedMin;
    @JsonProperty("fuelConsumptionCombinedMax")
    private Double fuelConsumptionCombinedMax;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("maxTrunkCapacity")
    public Integer getMaxTrunkCapacity() {
        return maxTrunkCapacity;
    }

    @JsonProperty("maxTrunkCapacity")
    public void setMaxTrunkCapacity(Integer maxTrunkCapacity) {
        this.maxTrunkCapacity = maxTrunkCapacity;
    }

    @JsonProperty("doors")
    public Integer getDoors() {
        return doors;
    }

    @JsonProperty("doors")
    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    @JsonProperty("efficiencyClass")
    public String getEfficiencyClass() {
        return efficiencyClass;
    }

    @JsonProperty("efficiencyClass")
    public void setEfficiencyClass(String efficiencyClass) {
        this.efficiencyClass = efficiencyClass;
    }

    @JsonProperty("driveConcept")
    public String getDriveConcept() {
        return driveConcept;
    }

    @JsonProperty("driveConcept")
    public void setDriveConcept(String driveConcept) {
        this.driveConcept = driveConcept;
    }

    @JsonProperty("ratedOutputKw")
    public Integer getRatedOutputKw() {
        return ratedOutputKw;
    }

    @JsonProperty("ratedOutputKw")
    public void setRatedOutputKw(Integer ratedOutputKw) {
        this.ratedOutputKw = ratedOutputKw;
    }

    @JsonProperty("basePrice_eur")
    public Double getBasePriceEur() {
        return basePriceEur;
    }

    @JsonProperty("basePrice_eur")
    public void setBasePriceEur(Double basePriceEur) {
        this.basePriceEur = basePriceEur;
    }

    @JsonProperty("generalColor")
    public String getGeneralColor() {
        return generalColor;
    }

    @JsonProperty("generalColor")
    public void setGeneralColor(String generalColor) {
        this.generalColor = generalColor;
    }

    @JsonProperty("minTrunkCapacity")
    public Integer getMinTrunkCapacity() {
        return minTrunkCapacity;
    }

    @JsonProperty("minTrunkCapacity")
    public void setMinTrunkCapacity(Integer minTrunkCapacity) {
        this.minTrunkCapacity = minTrunkCapacity;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("engineConcept")
    public String getEngineConcept() {
        return engineConcept;
    }

    @JsonProperty("engineConcept")
    public void setEngineConcept(String engineConcept) {
        this.engineConcept = engineConcept;
    }

    @JsonProperty("fuelTypePrimary")
    public String getFuelTypePrimary() {
        return fuelTypePrimary;
    }

    @JsonProperty("fuelTypePrimary")
    public void setFuelTypePrimary(String fuelTypePrimary) {
        this.fuelTypePrimary = fuelTypePrimary;
    }

    @JsonProperty("seats")
    public Integer getSeats() {
        return seats;
    }

    @JsonProperty("seats")
    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @JsonProperty("fuelConsumptionCombinedMin")
    public Double getFuelConsumptionCombinedMin() {
        return fuelConsumptionCombinedMin;
    }

    @JsonProperty("fuelConsumptionCombinedMin")
    public void setFuelConsumptionCombinedMin(Double fuelConsumptionCombinedMin) {
        this.fuelConsumptionCombinedMin = fuelConsumptionCombinedMin;
    }

    @JsonProperty("fuelConsumptionCombinedMax")
    public Double getFuelConsumptionCombinedMax() {
        return fuelConsumptionCombinedMax;
    }

    @JsonProperty("fuelConsumptionCombinedMax")
    public void setFuelConsumptionCombinedMax(Double fuelConsumptionCombinedMax) {
        this.fuelConsumptionCombinedMax = fuelConsumptionCombinedMax;
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
