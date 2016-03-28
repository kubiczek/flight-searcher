package com.lastminute.service;

import com.lastminute.model.Airline;
import com.lastminute.model.Passengers;
import com.lastminute.model.SearchResult;
import com.lastminute.repository.InMemoryRepository;

import java.time.Clock;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by kubiczek on 3/28/16.
 */
public class FlightSearcherService {
    private Clock clock = Clock.systemDefaultZone();
    private InMemoryRepository repository;

    public FlightSearcherService(InMemoryRepository repository) {
        this.repository = repository;
    }

    public FlightSearcherService(Clock clock, InMemoryRepository repository) {
        this.clock = clock;
        this.repository = repository;
    }

    public List<SearchResult> search(String origin, String destination, LocalDate departureDate, Passengers passengers) {
        long daysToDeparture = ChronoUnit.DAYS.between(LocalDate.now(clock), departureDate);
        double daysToDepartureFactor = daysToDepartureFactor(daysToDeparture);

        return repository
                .findFlightByOriginAndDestination(origin, destination)
                .stream()
                .map(flight -> {
                    Optional<Airline> airline = repository.findAirlineByIata(flight.getAirline().substring(0, 2));
                    double infantPrice = airline.get().getInfantPrice();
                    double basePrice = flight.getBasePrice();
                    double totalPrice = passengers.getAdult() * daysToDepartureFactor * basePrice
                            + passengers.getChild() * 0.67 * daysToDepartureFactor * basePrice
                            + passengers.getInfant() * infantPrice;
                    return new SearchResult(flight.getAirline(), totalPrice);
                })
                .collect(Collectors.toList());
    }

    private double daysToDepartureFactor(long daysToDeparture) {
        if (daysToDeparture < 3) {
            return 1.5;
        } else if (daysToDeparture <= 15) {
            return 1.2;
        } else if (daysToDeparture < 30) {
            return 1;
        }
        // will give 80% discount for 30 days to departure booking
        // which is in-line with the first example, however, the pricing
        // rules state 'more than 30 days' to get 80% discount
        return 0.8;
    }
}
