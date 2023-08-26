package com.mustafayanar.amadeus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mustafayanar.amadeus.model.Airport;

public interface AirportRepository extends MongoRepository<Airport, Integer>
{
    
}