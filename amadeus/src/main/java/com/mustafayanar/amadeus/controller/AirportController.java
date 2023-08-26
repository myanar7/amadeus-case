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

import com.mustafayanar.amadeus.model.Airport;
import com.mustafayanar.amadeus.service.AirportService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
public class AirportController {
    
    @Autowired
    AirportService service;

    @GetMapping("/airport/all")
    @ApiOperation(value = "Get all airports", notes = "Returns a list of all airports")
    @CrossOrigin
    public List<Airport> getAllAirports()
    {
        return service.getAllAirports();
    }

    @PostMapping("/airport/")
    @CrossOrigin
    public Airport addAirport(@RequestBody Airport airport)
    {
        return service.addAirport(airport);
    }

    @GetMapping("/airport/{id}")
    @CrossOrigin
    public Airport getAirportById(@PathVariable int id)
    {
        return service.getAirportById(id);
    }

    @GetMapping("/airport/find/{city}")
    @CrossOrigin
    public List<Airport> findAirportsByCity(@PathVariable String city)
    {
        return service.findAirportsByCity(city);
    }

    @DeleteMapping("/airport/{id}")
    @CrossOrigin
    public String deleteAirport(@PathVariable int id)
    {
        return service.deleteAirport(id);
    }

    @PutMapping("/airport/")
    @CrossOrigin
    public Airport updateAirport(@RequestBody Airport airport)
    {
        return service.updateAirport(airport);
    }
}

