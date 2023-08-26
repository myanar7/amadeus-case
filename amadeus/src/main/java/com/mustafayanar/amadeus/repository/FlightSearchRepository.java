package com.mustafayanar.amadeus.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mustafayanar.amadeus.model.DateTime;
import com.mustafayanar.amadeus.model.Flight;

@Component
public interface FlightSearchRepository {
    List<Flight> findFlightsByDirectionAndDepartureDate(String departureCity, String arrivalCity, DateTime departureDate);
    List<Flight> findFlightsByDirectionAndArrivalDate(String departureCity, String arrivalCity, DateTime arrivalDate);
}
