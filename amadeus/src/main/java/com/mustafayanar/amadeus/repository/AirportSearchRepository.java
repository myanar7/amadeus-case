package com.mustafayanar.amadeus.repository;

import java.util.List;
import org.springframework.stereotype.Component;
import com.mustafayanar.amadeus.model.Airport;

@Component
public interface AirportSearchRepository {
    public List<Airport> findAirportsByCity(String city);
}
