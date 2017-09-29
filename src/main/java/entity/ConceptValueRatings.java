
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
    "kompakt",
    "sportlich",
    "eleganz",
    "gelaende",
    "sicherheit",
    "stauraum",
    "rundumSicht",
    "geraeumig",
    "luxus",
    "sportlichesDesign",
    "extravaganz",
    "offenFahren",
    "effizient"
})
public class ConceptValueRatings {

    @JsonProperty("kompakt")
    private double kompakt;
    @JsonProperty("sportlich")
    private Double sportlich;
    @JsonProperty("eleganz")
    private Double eleganz;
    @JsonProperty("gelaende")
    private Double gelaende;
    @JsonProperty("sicherheit")
    private double sicherheit;
    @JsonProperty("stauraum")
    private Double stauraum;
    @JsonProperty("rundumSicht")
    private Double rundumSicht;
    @JsonProperty("geraeumig")
    private Double geraeumig;
    @JsonProperty("luxus")
    private Double luxus;
    @JsonProperty("sportlichesDesign")
    private Double sportlichesDesign;
    @JsonProperty("extravaganz")
    private Double extravaganz;
    @JsonProperty("offenFahren")
    private double offenFahren;
    @JsonProperty("effizient")
    private Double effizient;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("kompakt")
    public double getKompakt() {
        return kompakt;
    }

    @JsonProperty("kompakt")
    public void setKompakt(double kompakt) {
        this.kompakt = kompakt;
    }

    @JsonProperty("sportlich")
    public Double getSportlich() {
        return sportlich;
    }

    @JsonProperty("sportlich")
    public void setSportlich(Double sportlich) {
        this.sportlich = sportlich;
    }

    @JsonProperty("eleganz")
    public Double getEleganz() {
        return eleganz;
    }

    @JsonProperty("eleganz")
    public void setEleganz(Double eleganz) {
        this.eleganz = eleganz;
    }

    @JsonProperty("gelaende")
    public Double getGelaende() {
        return gelaende;
    }

    @JsonProperty("gelaende")
    public void setGelaende(Double gelaende) {
        this.gelaende = gelaende;
    }

    @JsonProperty("sicherheit")
    public double getSicherheit() {
        return sicherheit;
    }

    @JsonProperty("sicherheit")
    public void setSicherheit(double sicherheit) {
        this.sicherheit = sicherheit;
    }

    @JsonProperty("stauraum")
    public Double getStauraum() {
        return stauraum;
    }

    @JsonProperty("stauraum")
    public void setStauraum(Double stauraum) {
        this.stauraum = stauraum;
    }

    @JsonProperty("rundumSicht")
    public Double getRundumSicht() {
        return rundumSicht;
    }

    @JsonProperty("rundumSicht")
    public void setRundumSicht(Double rundumSicht) {
        this.rundumSicht = rundumSicht;
    }

    @JsonProperty("geraeumig")
    public Double getGeraeumig() {
        return geraeumig;
    }

    @JsonProperty("geraeumig")
    public void setGeraeumig(Double geraeumig) {
        this.geraeumig = geraeumig;
    }

    @JsonProperty("luxus")
    public Double getLuxus() {
        return luxus;
    }

    @JsonProperty("luxus")
    public void setLuxus(Double luxus) {
        this.luxus = luxus;
    }

    @JsonProperty("sportlichesDesign")
    public Double getSportlichesDesign() {
        return sportlichesDesign;
    }

    @JsonProperty("sportlichesDesign")
    public void setSportlichesDesign(Double sportlichesDesign) {
        this.sportlichesDesign = sportlichesDesign;
    }

    @JsonProperty("extravaganz")
    public Double getExtravaganz() {
        return extravaganz;
    }

    @JsonProperty("extravaganz")
    public void setExtravaganz(Double extravaganz) {
        this.extravaganz = extravaganz;
    }

    @JsonProperty("offenFahren")
    public double getOffenFahren() {
        return offenFahren;
    }

    @JsonProperty("offenFahren")
    public void setOffenFahren(double offenFahren) {
        this.offenFahren = offenFahren;
    }

    @JsonProperty("effizient")
    public Double getEffizient() {
        return effizient;
    }

    @JsonProperty("effizient")
    public void setEffizient(Double effizient) {
        this.effizient = effizient;
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
