package com.mustafayanar.amadeus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mustafayanar.amadeus.model.Flight;

public interface FlightRepository extends MongoRepository<Flight, Integer> 
{
    
}
