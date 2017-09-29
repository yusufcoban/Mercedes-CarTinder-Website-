
package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "series",
    "model",
    "modelImageUrl",
    "equipments",
    "segment",
    "positioningText",
    "conceptValueRatings",
    "codeSet",
    "label",
    "technicalValues",
    "typeClass",
    "highlight",
    "altLabel",
    "bodyType",
    "conceptValueExplanations",
    "esScore"
})
public class MercedesCar {

    @JsonProperty("series")
    private String series;
    @JsonProperty("model")
    private String model;
    @JsonProperty("modelImageUrl")
    private String modelImageUrl;
    @JsonProperty("equipments")
    private List<String> equipments = null;
    @JsonProperty("segment")
    private String segment;
    @JsonProperty("positioningText")
    private String positioningText;
    @JsonProperty("conceptValueRatings")
    private ConceptValueRatings conceptValueRatings;
    @JsonProperty("codeSet")
    private String codeSet;
    @JsonProperty("label")
    private String label;
    @JsonProperty("technicalValues")
    private TechnicalValues technicalValues;
    @JsonProperty("typeClass")
    private String typeClass;
    @JsonProperty("highlight")
    private Highlight highlight;
    @JsonProperty("altLabel")
    private String altLabel;
    @JsonProperty("bodyType")
    private String bodyType;
    @JsonProperty("conceptValueExplanations")
    private ConceptValueExplanations conceptValueExplanations;
    @JsonProperty("esScore")
    private Double esScore;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("series")
    public String getSeries() {
        return series;
    }

    @JsonProperty("series")
    public void setSeries(String series) {
        this.series = series;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("modelImageUrl")
    public String getModelImageUrl() {
        return modelImageUrl;
    }

    @JsonProperty("modelImageUrl")
    public void setModelImageUrl(String modelImageUrl) {
        this.modelImageUrl = modelImageUrl;
    }

    @JsonProperty("equipments")
    public List<String> getEquipments() {
        return equipments;
    }

    @JsonProperty("equipments")
    public void setEquipments(List<String> equipments) {
        this.equipments = equipments;
    }

    @JsonProperty("segment")
    public String getSegment() {
        return segment;
    }

    @JsonProperty("segment")
    public void setSegment(String segment) {
        this.segment = segment;
    }

    @JsonProperty("positioningText")
    public String getPositioningText() {
        return positioningText;
    }

    @JsonProperty("positioningText")
    public void setPositioningText(String positioningText) {
        this.positioningText = positioningText;
    }

    @JsonProperty("conceptValueRatings")
    public ConceptValueRatings getConceptValueRatings() {
        return conceptValueRatings;
    }

    @JsonProperty("conceptValueRatings")
    public void setConceptValueRatings(ConceptValueRatings conceptValueRatings) {
        this.conceptValueRatings = conceptValueRatings;
    }

    @JsonProperty("codeSet")
    public String getCodeSet() {
        return codeSet;
    }

    @JsonProperty("codeSet")
    public void setCodeSet(String codeSet) {
        this.codeSet = codeSet;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("technicalValues")
    public TechnicalValues getTechnicalValues() {
        return technicalValues;
    }

    @JsonProperty("technicalValues")
    public void setTechnicalValues(TechnicalValues technicalValues) {
        this.technicalValues = technicalValues;
    }

    @JsonProperty("typeClass")
    public String getTypeClass() {
        return typeClass;
    }

    @JsonProperty("typeClass")
    public void setTypeClass(String typeClass) {
        this.typeClass = typeClass;
    }

    @JsonProperty("highlight")
    public Highlight getHighlight() {
        return highlight;
    }

    @JsonProperty("highlight")
    public void setHighlight(Highlight highlight) {
        this.highlight = highlight;
    }

    @JsonProperty("altLabel")
    public String getAltLabel() {
        return altLabel;
    }

    @JsonProperty("altLabel")
    public void setAltLabel(String altLabel) {
        this.altLabel = altLabel;
    }

    @JsonProperty("bodyType")
    public String getBodyType() {
        return bodyType;
    }

    @JsonProperty("bodyType")
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @JsonProperty("conceptValueExplanations")
    public ConceptValueExplanations getConceptValueExplanations() {
        return conceptValueExplanations;
    }

    @JsonProperty("conceptValueExplanations")
    public void setConceptValueExplanations(ConceptValueExplanations conceptValueExplanations) {
        this.conceptValueExplanations = conceptValueExplanations;
    }

    @JsonProperty("esScore")
    public Double getEsScore() {
        return esScore;
    }

    @JsonProperty("esScore")
    public void setEsScore(Double esScore) {
        this.esScore = esScore;
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
