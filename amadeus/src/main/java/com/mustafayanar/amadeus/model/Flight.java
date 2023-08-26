package com.mustafayanar.amadeus.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "flight")
public class Flight {
    private Integer id;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private DateTime departureTime;
    private DateTime arrivalTime;
    private double price;

    public Flight() {
    }

    public Integer getId() {
        return id;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public DateTime getDepartureDate() {
        return departureTime;
    }

    public DateTime getArrivalDate() {
        return arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setDepartureDate(DateTime departureDate) {
        this.departureTime = departureDate;
    }

    public void setArrivalDate(DateTime arrivalDate) {
        this.arrivalTime = arrivalDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departureAirport='" + departureAirport.toString() + '\'' +
                ", arrivalAirport='" + arrivalAirport.toString() + '\'' +
                ", departureDate='" + departureTime.toString() + '\'' +
                ", arrivalDate='" + arrivalTime.toString() + '\'' +
                ", price=" + price +
                '}';
    }

    @Override 
    public boolean equals(Object obj) {
        if (obj instanceof Flight) {
            Flight flight = (Flight) obj;
            return this.id.equals(flight.getId()) && this.departureAirport.equals(flight.getDepartureAirport()) && this.arrivalAirport.equals(flight.getArrivalAirport()) && this.departureTime.equals(flight.getDepartureDate()) && this.arrivalTime.equals(flight.getArrivalDate()) && this.price == flight.getPrice();
        }
        return false;
    }
}
