package com.lastminute.repository;

import com.lastminute.model.Airline;
import com.lastminute.model.Flight;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by vagrant on 3/28/16.
 */
public class InMemoryRepositoryTest {
    private InMemoryRepository repository;

    @Before
    public void setUp() {
        this.repository = new InMemoryRepository(TestDataUtil.airlines(), TestDataUtil.flights());
    }

    @Test
    public void findAirlineByIata_shouldReturnSomeAirline_whenIataExists() {
        Optional<Airline> airline = repository.findAirlineByIata("IB");

        assertThat(airline).hasValueSatisfying(v -> {
                    assertThat(v.getIata()).isEqualTo("IB");
                    assertThat(v.getName()).isEqualTo("Iberia");
                    assertThat(v.getInfantPrice()).isEqualTo(10.0);
                }
        );
    }

    @Test
    public void findAirlineByIata_shouldReturnNoneAirline_whenIataDoesNotExists() {
        Optional<Airline> airline = repository.findAirlineByIata("UNKNOWN");

        assertThat(airline.isPresent()).isFalse();
    }

    @Test
    public void findFlightByOriginAndDestination_shouldReturnThreeFlights_whenSearchForFlightFromAmsToFra() {
        List<Flight> flights = repository.findFlightByOriginAndDestination("AMS", "FRA");

        assertThat(flights.size()).isEqualTo(3);
        flights.stream().forEach(flight -> {
            assertThat(flight.getOrigin()).isEqualTo("AMS");
            assertThat(flight.getDestination()).isEqualTo("FRA");
        });

        assertThat(flights.get(0).getAirline()).isEqualTo("TK2372");
        assertThat(flights.get(0).getBasePrice()).isEqualTo(197);
        assertThat(flights.get(1).getAirline()).isEqualTo("TK2659");
        assertThat(flights.get(1).getBasePrice()).isEqualTo(248);
        assertThat(flights.get(2).getAirline()).isEqualTo("LH5909");
        assertThat(flights.get(2).getBasePrice()).isEqualTo(113);
    }

    @Test
    public void findFlightByOriginAndDestination_shouldReturnTwoFlights_whenSearchForFlightFromLhrToIst() {
        List<Flight> flights = repository.findFlightByOriginAndDestination("LHR", "IST");

        assertThat(flights.size()).isEqualTo(2);
        flights.stream().forEach(flight -> {
            assertThat(flight.getOrigin()).isEqualTo("LHR");
            assertThat(flight.getDestination()).isEqualTo("IST");
        });

        assertThat(flights.get(0).getAirline()).isEqualTo("TK8891");
        assertThat(flights.get(0).getBasePrice()).isEqualTo(250);
        assertThat(flights.get(1).getAirline()).isEqualTo("LH1085");
        assertThat(flights.get(1).getBasePrice()).isEqualTo(148);
    }

    @Test
    public void findFlightByOriginAndDestination_shouldReturnTwoFlights_whenSearchForFlightFromBcnToMad() {
        List<Flight> flights = repository.findFlightByOriginAndDestination("BCN", "MAD");

        assertThat(flights.size()).isEqualTo(2);
        flights.stream().forEach(flight -> {
            assertThat(flight.getOrigin()).isEqualTo("BCN");
            assertThat(flight.getDestination()).isEqualTo("MAD");
        });

        assertThat(flights.get(0).getAirline()).isEqualTo("IB2171");
        assertThat(flights.get(0).getBasePrice()).isEqualTo(259);
        assertThat(flights.get(1).getAirline()).isEqualTo("LH5496");
        assertThat(flights.get(1).getBasePrice()).isEqualTo(293);
    }

    @Test
    public void findFlightByOriginAndDestination_shouldEmptyList_whenSearchForFlightFromCgdToFra() {
        List<Flight> flights = repository.findFlightByOriginAndDestination("CGD", "FRA");

        assertThat(flights.isEmpty()).isTrue();
    }
}