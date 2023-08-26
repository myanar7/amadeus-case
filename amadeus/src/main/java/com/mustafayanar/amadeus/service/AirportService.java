package com.mustafayanar.amadeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustafayanar.amadeus.model.Airport;
import com.mustafayanar.amadeus.repository.AirportRepository;
import com.mustafayanar.amadeus.repository.AirportSearchRepository;

@Service
public class AirportService {
    
    @Autowired
    AirportRepository repo;
    
    @Autowired
    AirportSearchRepository searchRepo;
    
    public List<Airport> getAllAirports()
    {
        return repo.findAll();
    }

    public Airport getAirportById(int id)
    {
        return repo.findById(id).orElse(null);
    }

    public Airport addAirport(Airport airport)
    {
        return repo.save(airport);
    }

    public String deleteAirport(int id)
    {
        repo.deleteById(id);
        return "Airport removed !! " + id;
    }

    public Airport updateAirport(Airport airport)
    {
        Airport existingAirport = repo.findById(airport.getId()).orElse(null);
        existingAirport.setCity(airport.getCity());
        return repo.save(existingAirport);
    }

    public List<Airport> findAirportsByCity(String city)
    {
        return searchRepo.findAirportsByCity(city);
    }
}
