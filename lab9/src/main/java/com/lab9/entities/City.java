package com.lab9.entities;

import com.lab9.repositories.CountryRepository;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "cities")
@NamedQueries({
        @NamedQuery(name = "City.findAll",
                query = "select distinct e from City e order by e.name"),
        @NamedQuery(name = "City.findByName",
                query = "select distinct e from City e where e.name = :name"),
        @NamedQuery(name = "City.findByCountry",
                query = "select distinct e from City e where e.country = :country order by e.name"),
        @NamedQuery(name = "City.findByFirstLetter",
                query = "select distinct e from City e where substring(e.name, 1, 1) = :letter order by e.name"),
        @NamedQuery(name = "City.findByPopulation",
                query = "select distinct e from City e where e.population = :population order by e.name"),
})

public class City extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country")
    private Country country;

    @Column(name = "capital")
    private Boolean capital;

    @Column(name = "latitude", nullable = false)
    private Float latitude;

    @Column(name = "longitude", nullable = false)
    private Float longitude;

    @Column(name = "population", nullable = false)
    private Integer population;

    public City(String name, Integer country, boolean capital, float latitude, float longitude, Integer population) {

        this.name = name;
        this.country = (Country) (new CountryRepository()).findById(country);
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
        this.population = population;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Integer getPopulation() { return population; }

    public void setPopulation(Integer population) { this.population = population; }
}