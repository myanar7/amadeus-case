package com.mustafayanar.amadeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustafayanar.amadeus.model.DateTime;
import com.mustafayanar.amadeus.model.Flight;
import com.mustafayanar.amadeus.model.FlightSearchResponse;
import com.mustafayanar.amadeus.repository.FlightSearchRepository;

@Service
public class SearchService {
    
    @Autowired
    AirportService airportService;

    @Autowired
    FlightService flightService;

    @Autowired
    FlightSearchRepository flightSearchRepository;

    public FlightSearchResponse getFlightsByFilter(String departureCityString, String arrivalCityString, DateTime departureDate, DateTime arrivalDate)
    {
        FlightSearchResponse response = new FlightSearchResponse();

        List<Flight> departureFlights = flightSearchRepository.findFlightsByDirectionAndDepartureDate(departureCityString, arrivalCityString, departureDate);
        response.setDepartureAirports(departureFlights);
        
        if (arrivalDate != null) {
            List<Flight> arrivalFlights = flightSearchRepository.findFlightsByDirectionAndArrivalDate(departureCityString, arrivalCityString, arrivalDate);
            response.setArrivalAirports(arrivalFlights);
        }
        
        return response;
    }
}
