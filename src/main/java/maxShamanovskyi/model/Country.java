package maxShamanovskyi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Map;

public class Country {
    @Id
    @ApiModelProperty(notes = "The database country id")
    private String id;
    @ApiModelProperty(notes = "The name of country")
    private String name;
    @ApiModelProperty(notes = "The population of country")
    private Double population;
    @ApiModelProperty(notes = "The area of country")
    private Double area;
    @ApiModelProperty(notes = "The president of country")
    private String president;
    @ApiModelProperty(notes = "The vice president of country")
    private String vicePresident;
    @ApiModelProperty(notes = "The capital of country")
    private String capital;
    @ApiModelProperty(notes = "The languages of country")
    private Map<String, Double> languages;
    @ApiModelProperty(notes = "The GDP of country")
    private Double gdp;

    public Country() {
    }

    public Country(String name, Double population, Double area, String president, String vicePresident,
                   String capital, Map<String, Double> languages, Double gdp) {
        this.name = name;
        this.population = population;
        this.area = area;
        this.president = president;
        this.vicePresident = vicePresident;
        this.capital = capital;
        this.languages = languages;
        this.gdp = gdp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getVicePresident() {
        return vicePresident;
    }

    public void setVicePresident(String vicePresident) {
        this.vicePresident = vicePresident;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Map<String, Double> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, Double> languages) {
        this.languages = languages;
    }

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    @ApiModel(description = "Country languages")
    public static class Language implements Serializable{
        @ApiModelProperty(notes = "The language name")
        private String name;
        @ApiModelProperty(notes = "The language quality")
        private Double quality;
    }
}
