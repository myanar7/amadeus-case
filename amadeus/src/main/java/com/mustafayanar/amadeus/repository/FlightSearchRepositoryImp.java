package com.mustafayanar.amadeus.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mustafayanar.amadeus.model.DateTime;
import com.mustafayanar.amadeus.model.Flight;

@Component
public class FlightSearchRepositoryImp implements FlightSearchRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Flight> findFlightsByDirectionAndDepartureDate(String departureCity, String arrivalCity,
            DateTime departureDate) {
        final List<Flight> flights = new ArrayList<>();

        MongoDatabase database = client.getDatabase("amadeus");
        MongoCollection<Document> collection = database.getCollection("flight");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match", 
        new Document("arrivalAirport.city", arrivalCity)
            .append("departureAirport.city", departureCity)
            .append("departureTime.day", departureDate.getDay())
            .append("departureTime.month", departureDate.getMonth())
            .append("departureTime.year", departureDate.getYear()))));
        
        result.forEach(doc -> flights.add(converter.read(Flight.class,doc)));
        return flights;
    }
    
    @Override
    public List<Flight> findFlightsByDirectionAndArrivalDate(String departureCity, String arrivalCity, DateTime arrivalDate) {
        final List<Flight> flights = new ArrayList<>();

        MongoDatabase database = client.getDatabase("amadeus");
        MongoCollection<Document> collection = database.getCollection("flight");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match", 
        new Document("arrivalAirport.city", arrivalCity)
            .append("departureAirport.city", departureCity)
            .append("arrivalTime.day", arrivalDate.getDay())
            .append("arrivalTime.month", arrivalDate.getMonth())
            .append("arrivalTime.year", arrivalDate.getYear()))));
        
        result.forEach(doc -> flights.add(converter.read(Flight.class,doc)));
        return flights;
    }
    
}
