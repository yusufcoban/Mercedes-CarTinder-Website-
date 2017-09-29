
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
public class ConceptValueExplanations {

    @JsonProperty("kompakt")
    private Kompakt kompakt;
    @JsonProperty("sportlich")
    private Sportlich sportlich;
    @JsonProperty("eleganz")
    private Eleganz eleganz;
    @JsonProperty("gelaende")
    private Gelaende gelaende;
    @JsonProperty("sicherheit")
    private Sicherheit sicherheit;
    @JsonProperty("stauraum")
    private Stauraum stauraum;
    @JsonProperty("rundumSicht")
    private RundumSicht rundumSicht;
    @JsonProperty("geraeumig")
    private Geraeumig geraeumig;
    @JsonProperty("luxus")
    private Luxus luxus;
    @JsonProperty("sportlichesDesign")
    private SportlichesDesign sportlichesDesign;
    @JsonProperty("extravaganz")
    private Extravaganz extravaganz;
    @JsonProperty("offenFahren")
    private OffenFahren offenFahren;
    @JsonProperty("effizient")
    private Effizient effizient;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("kompakt")
    public Kompakt getKompakt() {
        return kompakt;
    }

    @JsonProperty("kompakt")
    public void setKompakt(Kompakt kompakt) {
        this.kompakt = kompakt;
    }

    @JsonProperty("sportlich")
    public Sportlich getSportlich() {
        return sportlich;
    }

    @JsonProperty("sportlich")
    public void setSportlich(Sportlich sportlich) {
        this.sportlich = sportlich;
    }

    @JsonProperty("eleganz")
    public Eleganz getEleganz() {
        return eleganz;
    }

    @JsonProperty("eleganz")
    public void setEleganz(Eleganz eleganz) {
        this.eleganz = eleganz;
    }

    @JsonProperty("gelaende")
    public Gelaende getGelaende() {
        return gelaende;
    }

    @JsonProperty("gelaende")
    public void setGelaende(Gelaende gelaende) {
        this.gelaende = gelaende;
    }

    @JsonProperty("sicherheit")
    public Sicherheit getSicherheit() {
        return sicherheit;
    }

    @JsonProperty("sicherheit")
    public void setSicherheit(Sicherheit sicherheit) {
        this.sicherheit = sicherheit;
    }

    @JsonProperty("stauraum")
    public Stauraum getStauraum() {
        return stauraum;
    }

    @JsonProperty("stauraum")
    public void setStauraum(Stauraum stauraum) {
        this.stauraum = stauraum;
    }

    @JsonProperty("rundumSicht")
    public RundumSicht getRundumSicht() {
        return rundumSicht;
    }

    @JsonProperty("rundumSicht")
    public void setRundumSicht(RundumSicht rundumSicht) {
        this.rundumSicht = rundumSicht;
    }

    @JsonProperty("geraeumig")
    public Geraeumig getGeraeumig() {
        return geraeumig;
    }

    @JsonProperty("geraeumig")
    public void setGeraeumig(Geraeumig geraeumig) {
        this.geraeumig = geraeumig;
    }

    @JsonProperty("luxus")
    public Luxus getLuxus() {
        return luxus;
    }

    @JsonProperty("luxus")
    public void setLuxus(Luxus luxus) {
        this.luxus = luxus;
    }

    @JsonProperty("sportlichesDesign")
    public SportlichesDesign getSportlichesDesign() {
        return sportlichesDesign;
    }

    @JsonProperty("sportlichesDesign")
    public void setSportlichesDesign(SportlichesDesign sportlichesDesign) {
        this.sportlichesDesign = sportlichesDesign;
    }

    @JsonProperty("extravaganz")
    public Extravaganz getExtravaganz() {
        return extravaganz;
    }

    @JsonProperty("extravaganz")
    public void setExtravaganz(Extravaganz extravaganz) {
        this.extravaganz = extravaganz;
    }

    @JsonProperty("offenFahren")
    public OffenFahren getOffenFahren() {
        return offenFahren;
    }

    @JsonProperty("offenFahren")
    public void setOffenFahren(OffenFahren offenFahren) {
        this.offenFahren = offenFahren;
    }

    @JsonProperty("effizient")
    public Effizient getEffizient() {
        return effizient;
    }

    @JsonProperty("effizient")
    public void setEffizient(Effizient effizient) {
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
