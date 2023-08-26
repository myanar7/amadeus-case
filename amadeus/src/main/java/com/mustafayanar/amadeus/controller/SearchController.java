package com.mustafayanar.amadeus.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mustafayanar.amadeus.model.FlightSearchRequest;
import com.mustafayanar.amadeus.model.FlightSearchResponse;
import com.mustafayanar.amadeus.service.SearchService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SearchController {

    @Autowired
    SearchService service;
    
    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @PostMapping("/search")
    @CrossOrigin
    public FlightSearchResponse getFlights(@RequestBody FlightSearchRequest search)
    {
        return service.getFlightsByFilter(search.getDepartureCityString(), search.getArrivalCityString(), search.getDepartureDateTime(), search.getArrivalDateTime());
    }
}