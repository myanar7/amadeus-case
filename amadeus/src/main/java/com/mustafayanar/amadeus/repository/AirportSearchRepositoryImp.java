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
import com.mustafayanar.amadeus.model.Airport;

@Component
public class AirportSearchRepositoryImp implements AirportSearchRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Airport> findAirportsByCity(String city) {

        final List<Airport> airports = new ArrayList<>();

        MongoDatabase database = client.getDatabase("amadeus");
        MongoCollection<Document> collection = database.getCollection("airport");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                        new Document("query", city)
                        .append("path", "city"))),
                        new Document("$limit", 5L)));
        //converter.read(Airport.class,result.first()); 
        result.forEach(doc -> airports.add(converter.read(Airport.class,doc)));

        return airports;
    }
    
}
