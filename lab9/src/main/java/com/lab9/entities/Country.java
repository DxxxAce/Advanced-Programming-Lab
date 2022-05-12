package com.lab9.entities;

import com.lab9.repositories.ContinentRepository;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "countries")
@NamedQueries({
        @NamedQuery(name = "Country.findAll",
                query = "select distinct e from Country e order by e.name"),
        @NamedQuery(name = "Country.findByName",
                query = "select distinct e from Country e where e.name = :name"),
        @NamedQuery(name = "Country.findByContinent",
                query = "select distinct e from Country e where e.continent = :continent order by e.name"),
})

public class Country extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "continent")
    private Continent continent;

    @Column(name = "code", length = 256)
    private String code;

    @OneToMany(mappedBy = "country")
    private Set<City> cities = new LinkedHashSet<>();

    public Country(String name, Integer continent, String code) {

        this.name = name;
        this.continent = (Continent) (new ContinentRepository()).findById(continent);
        this.code = code;
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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

}