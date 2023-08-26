package com.mustafayanar.amadeus.model;

import java.util.List;

public class FlightSearchResponse {
    private List<Flight> departureAirports;
    private List<Flight> arrivalAirports;

    public FlightSearchResponse() {
    }

    public List<Flight> getDepartureAirports() {
        return departureAirports;
    }

    public List<Flight> getArrivalAirports() {
        return arrivalAirports;
    }

    public void setDepartureAirports(List<Flight> departureAirports) {
        this.departureAirports = departureAirports;
    }

    public void setArrivalAirports(List<Flight> arrivalAirports) {
        this.arrivalAirports = arrivalAirports;
    }

    public String toString() {
        return "FlightSearchResponse{" +
                "departureAirports='" + departureAirports + '\'' +
                ", arrivalAirports='" + arrivalAirports + '\'' +
                '}';
    }
}
