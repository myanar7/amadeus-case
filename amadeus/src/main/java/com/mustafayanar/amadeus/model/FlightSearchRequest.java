package com.mustafayanar.amadeus.model;

public class FlightSearchRequest {
    
    private String departureCityString;
    private String arrivalCityString;
    private DateTime departureDateTime;
    private DateTime arrivalDateTime;

    public FlightSearchRequest() {
    }

    public String getDepartureCityString() {
        return departureCityString;
    }

    public String getArrivalCityString() {
        return arrivalCityString;
    }

    public DateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public DateTime getArrivalDateTime() {
        return arrivalDateTime;
    }
}
