package com.lastminute.repository;

import com.lastminute.model.Airline;
import com.lastminute.model.Flight;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by kubiczek on 3/28/16.
 */
public class InMemoryRepository {
    private List<Airline> airlines;
    private List<Flight> flights;

    public InMemoryRepository(List<Airline> airlines, List<Flight> flights) {
        this.airlines = airlines;
        this.flights = flights;
    }

    public Optional<Airline> findAirlineByIata(String iata) {
        return airlines.stream()
                .filter(airline -> airline.getIata().equals(iata))
                .findFirst();
    }

    public List<Flight> findFlightByOriginAndDestination(String origin, String destination) {
        return flights.stream()
                .filter(flight -> flight.getOrigin().equals(origin) && flight.getDestination().equals(destination))
                .collect(Collectors.toList());
    }
}
