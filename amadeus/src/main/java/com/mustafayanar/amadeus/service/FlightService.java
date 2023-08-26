package com.mustafayanar.amadeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustafayanar.amadeus.model.Airport;
import com.mustafayanar.amadeus.model.Flight;
import com.mustafayanar.amadeus.repository.AirportRepository;
import com.mustafayanar.amadeus.repository.FlightRepository;

@Service
public class FlightService {
    
    @Autowired
    FlightRepository repo;

    @Autowired
    AirportRepository airportRepo;


    public List<Flight> getAllFlights()
    {
        return repo.findAll();
    }

    public Flight addFlight(Flight flight)
    {
        return repo.save(flight);
    }

    public Flight getFlightById(int id)
    {
        return repo.findById(id).orElse(null);
    }

    public String deleteFlight(int id)
    {
        repo.deleteById(id);
        return "Flight removed !! " + id;
    }

    public Flight updateFlight(Flight flight)
    {
        Flight existingFlight = repo.findById(flight.getId()).orElse(null);
        Airport arrivalAirport = airportRepo.findById(flight.getArrivalAirport().getId()).orElse(null);
        Airport departureAirport = airportRepo.findById(flight.getDepartureAirport().getId()).orElse(null);
        existingFlight.setArrivalAirport(arrivalAirport);
        existingFlight.setDepartureAirport(departureAirport);
        existingFlight.setArrivalDate(flight.getArrivalDate());
        existingFlight.setDepartureDate(flight.getDepartureDate());
        existingFlight.setPrice(flight.getPrice());
        return repo.save(existingFlight);
    }
}
