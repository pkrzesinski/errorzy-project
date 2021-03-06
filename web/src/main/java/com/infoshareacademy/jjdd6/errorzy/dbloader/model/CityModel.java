package com.infoshareacademy.jjdd6.errorzy.dbloader.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "CITIES")
public class CityModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryModel country;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<PlaceModel> placeList;

    @Column(name = "lateral_coordinate", columnDefinition = "DECIMAL(10,6)")
    private double lat;

    @Column(name = "longitudinal_coordinate", columnDefinition = "DECIMAL(10,6)")
    private double lng;

    @Column(name = "city_name", length = 64, unique = true)
    @NotNull
    private String name;

    @Transient
    private int numPlaces;
    @Transient
    private int availableBikes;

    public CityModel() {
    }

    public CityModel(double lat, double lng, String name, CountryModel countryModel) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.country = countryModel;
    }

    public List<PlaceModel> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<PlaceModel> placeList) {
        this.placeList = placeList;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumPlaces() {
        return numPlaces;
    }

    public void setNumPlaces(int numPlaces) {
        this.numPlaces = numPlaces;
    }

    public int getAvailableBikes() {
        return availableBikes;
    }

    public void setAvailableBikes(int availableBikes) {
        this.availableBikes = availableBikes;
    }

    @Override
    public String toString() {
        return "CityModel{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", name='" + name + '\'' +
                ", placeList=" + placeList +
                '}';
    }
}
