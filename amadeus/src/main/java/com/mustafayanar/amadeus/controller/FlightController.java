package com.mustafayanar.amadeus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mustafayanar.amadeus.model.Flight;
import com.mustafayanar.amadeus.service.FlightService;

@RestController
@CrossOrigin(origins = "http://localhost:4000")
public class FlightController {
    
    @Autowired
    FlightService service;

    @GetMapping("/flight/all")
    @CrossOrigin
    public List<Flight> getAllFlights()
    {
        return service.getAllFlights();
    }

    @PostMapping("/flight")
    @CrossOrigin
    public Flight addFlight(@RequestBody Flight flight)
    {
        return service.addFlight(flight);
    }

    @GetMapping("/flight/{id}")
    @CrossOrigin
    public Flight getFlightById(@PathVariable int id)
    {
        return service.getFlightById(id);
    }

    @PutMapping("/flight/{id}")
    @CrossOrigin
    public Flight updateFlight(@RequestBody Flight flight)
    {
        return service.updateFlight(flight);
    }

    @DeleteMapping("/flight/{id}")
    @CrossOrigin
    public String deleteFlight(@PathVariable int id)
    {
        return service.deleteFlight(id);
    }
}
