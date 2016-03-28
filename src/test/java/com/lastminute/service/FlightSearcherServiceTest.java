package com.lastminute.service;

import com.lastminute.model.Passengers;
import com.lastminute.model.SearchResult;
import com.lastminute.repository.InMemoryRepository;
import com.lastminute.repository.TestDataUtil;
import org.junit.Before;
import org.junit.Test;

import java.time.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

/**
 * Created by kubiczek on 3/28/16.
 */
public class FlightSearcherServiceTest {
    FlightSearcherService service;

    private LocalDate today = LocalDate.of(2015, Month.MARCH, 28);
    private LocalDate todayPlus2days = today.plusDays(2);
    private LocalDate todayPlus15days = today.plusDays(15);
    private LocalDate todayPlus30days = today.plusDays(30);

    @Before
    public void setup() {
        this.service = new FlightSearcherService(
                // magical time machine
                Clock.fixed(today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault()),
                new InMemoryRepository(TestDataUtil.airlines(), TestDataUtil.flights()));
    }

    @Test
    public void search_shouldReturnThreeFlights_whenSearchForFlightFromAmsToFra() {
        List<SearchResult> result = service.search("AMS", "FRA", todayPlus30days, new Passengers(1, 0, 0));

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0).getFlightCode()).isEqualTo("TK2372");
        assertThat(result.get(0).getTotalPrice()).isCloseTo(157.6, within(0.0001));
        assertThat(result.get(1).getFlightCode()).isEqualTo("TK2659");
        assertThat(result.get(1).getTotalPrice()).isEqualTo(198.4);
        assertThat(result.get(2).getFlightCode()).isEqualTo("LH5909");
        assertThat(result.get(2).getTotalPrice()).isEqualTo(90.4);
    }

    @Test
    public void search_shouldReturnTwoFlights_whenSearchForFlightFromLhrToIst() {
        List<SearchResult> result = service.search("LHR", "IST", todayPlus15days, new Passengers(2,1,1));

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getFlightCode()).isEqualTo("TK8891");
        assertThat(result.get(0).getTotalPrice()).isEqualTo(806.0);
        assertThat(result.get(1).getFlightCode()).isEqualTo("LH1085");
        assertThat(result.get(1).getTotalPrice()).isCloseTo(481.19, within(0.01));
    }

    @Test
    public void search_shouldReturnTwoFlights_whenSearchForFlightFromBcnToMad() {
        List<SearchResult> result = service.search("BCN", "MAD", todayPlus2days, new Passengers(1,2,0));

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getFlightCode()).isEqualTo("IB2171");
        assertThat(result.get(0).getTotalPrice()).isEqualTo(909.09);
        assertThat(result.get(1).getFlightCode()).isEqualTo("LH5496");
        assertThat(result.get(1).getTotalPrice()).isEqualTo(1028.43);
    }

    @Test
    public void search_shouldReturnNoFlights_whenSearchForFlightFromCdgToFra() {
        List<SearchResult> result = service.search("CDG", "FRA", todayPlus2days, new Passengers(1,2,2));;

        assertThat(result.size()).isEqualTo(0);
    }
}
