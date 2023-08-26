package com.mustafayanar.amadeus.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "airport")
public class Airport {
    private Integer id;
    private String city;

    public Airport() {
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString() {
        return "Airport{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Airport) {
            Airport airport = (Airport) obj;
            return this.id.equals(airport.getId()) && this.city.equals(airport.getCity());
        }
        return false;
    }
}
