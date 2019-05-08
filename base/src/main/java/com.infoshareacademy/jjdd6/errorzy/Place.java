package com.infoshareacademy.jjdd6.errorzy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Entity
@Table(name = "PLACES")
public class Place {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "place")
    private List<Bike> bikeList;

    @Column(name = "lateral")
    private double lat;

    @Column(name = "longitudinal")
    private double lng;

    @Column(name = "place_name")
    @NotNull
    private String name;

    @Column(name = "place_number")
    private int number;

    @Transient
    private int bikes;
    @Transient
    private String bikeNumbers;


    public Place() {
    }

    public Place(double lat, double lng, String name, int number, List<Bike> bikeList) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.number = number;
        this.bikeList = bikeList;
    }

    @XmlAttribute(name = "lat")
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @XmlAttribute(name = "lng")
    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @XmlAttribute(name = "bikes")
    public int getBikes() {
        return bikes;
    }

    public void setBikes(int bikes) {
        this.bikes = bikes;
    }

    @XmlAttribute(name = "bike_numbers")
    public String getBikeNumbers() {
        return bikeNumbers;
    }

    public void setBikeNumbers(String bikeNumbers) {
        this.bikeNumbers = bikeNumbers;
    }

    @XmlElement(name = "bike")
    public List<Bike> getBikeList() {
        return bikeList;
    }

    public void setBikeList(List<Bike> bikeList) {
        this.bikeList = bikeList;
    }

    @Override
    public String toString() {
        return "Place{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", bikeList=" + bikeList +
                '}';
    }
}
