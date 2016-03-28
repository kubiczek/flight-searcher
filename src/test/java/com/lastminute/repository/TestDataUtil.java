package com.lastminute.repository;

import com.lastminute.model.Airline;
import com.lastminute.model.Airport;
import com.lastminute.model.Flight;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kubiczek on 3/28/16.
 */
public class TestDataUtil {
    public static List<Airport> airports() {
        return Arrays.stream(
                new Object[][]{
                        {"MAD", "Madrid"},
                        {"BCN", "Barcelona"},
                        {"LHR", "London"},
                        {"CDG", "Paris"},
                        {"FRA", "Frakfurt"},
                        {"IST", "Istanbul"},
                        {"AMS", "Amsterdam"},
                        {"FCO", "Rome"},
                        {"CPH", "Copenhagen"}})
                .map(row -> new Airport((String) row[0], (String) row[1]))
                .collect(Collectors.toList());
    }

    public static List<Airline> airlines() {
        return Arrays.stream(
                new Object[][]{
                        {"IB", "Iberia", 10.0},
                        {"BA", "British Airways", 15.0},
                        {"LH", "Lufthansa", 7.0},
                        {"FR", "Ryanair", 20.0},
                        {"VY", "Vueling", 10.0},
                        {"TK", "Turkish Airlines", 5.0},
                        {"U2", "Easyjet", 19.90}})
                .map(row -> new Airline((String) row[0], (String) row[1], (Double) row[2]))
                .collect(Collectors.toList());
    }

    public static List<Flight> flights() {
        return Arrays.stream(
                new Object[][]{
                        {"CPH", "FRA", "IB2818", 186},
                        {"CPH", "LHR", "U23631", 152},
                        {"CDG", "MAD", "IB8482", 295},
                        {"BCN", "FRA", "FR7521", 150},
                        {"CPH", "FCO", "TK4667", 137},
                        {"CPH", "FCO", "U24631", 268},
                        {"FCO", "CDG", "VY4335", 158},
                        {"LHR", "IST", "TK8891", 250},
                        {"FRA", "AMS", "U24107", 237},
                        {"CPH", "BCN", "U22593", 218},
                        {"BCN", "IST", "VY9890", 178},
                        {"AMS", "CPH", "TK4927", 290},
                        {"FCO", "MAD", "BA1164", 118},
                        {"CPH", "LHR", "BA7710", 138},
                        {"BCN", "AMS", "U24985", 191},
                        {"MAD", "CDG", "IB9961", 128},
                        {"LHR", "FRA", "LH2118", 165},
                        {"IST", "FRA", "IB8911", 180},
                        {"AMS", "FRA", "TK2372", 197},
                        {"FRA", "IST", "LH4145", 169},
                        {"MAD", "CDG", "IB6112", 112},
                        {"CPH", "FRA", "LH1678", 298},
                        {"LHR", "CPH", "LH6620", 217},
                        {"MAD", "LHR", "TK4199", 186},
                        {"MAD", "CDG", "IB7403", 253},
                        {"FRA", "CPH", "BA4369", 109},
                        {"BCN", "MAD", "IB2171", 259},
                        {"IST", "LHR", "LH6412", 197},
                        {"IST", "MAD", "LH1115", 160},
                        {"LHR", "LHR", "VY8162", 285},
                        {"FRA", "LHR", "BA8162", 205},
                        {"AMS", "FCO", "BA7610", 168},
                        {"LHR", "IST", "LH1085", 148},
                        {"FCO", "FRA", "U21423", 274},
                        {"CPH", "MAD", "U23282", 113},
                        {"CDG", "CPH", "LH5778", 263},
                        {"CPH", "CDG", "BA2777", 284},
                        {"BCN", "LHR", "TK4375", 208},
                        {"MAD", "FCO", "LH8408", 149},
                        {"AMS", "IST", "IB4563", 109},
                        {"LHR", "FCO", "LH5174", 251},
                        {"MAD", "BCN", "BA9569", 232},
                        {"AMS", "FRA", "TK2659", 248},
                        {"LHR", "CDG", "IB2771", 289},
                        {"IST", "MAD", "IB8688", 150},
                        {"CPH", "AMS", "TK8355", 137},
                        {"FCO", "CDG", "VY2974", 111},
                        {"AMS", "FRA", "LH5909", 113},
                        {"CPH", "BCN", "FR7949", 176},
                        {"BCN", "CPH", "U27858", 237},
                        {"FRA", "AMS", "LH2320", 288},
                        {"LHR", "BCN", "VY4633", 149},
                        {"AMS", "IST", "IB7289", 163},
                        {"FRA", "LHR", "IB9443", 254},
                        {"IST", "FCO", "LH4948", 176},
                        {"IST", "BCN", "TK5558", 211},
                        {"BCN", "BCN", "BA9409", 215},
                        {"IST", "AMS", "FR9261", 267},
                        {"CDG", "IST", "IB7181", 227},
                        {"LHR", "BCN", "TK1446", 217},
                        {"FCO", "FRA", "TK2793", 175},
                        {"AMS", "CPH", "FR1491", 284},
                        {"IST", "BCN", "IB9219", 279},
                        {"MAD", "AMS", "TK7871", 159},
                        {"FCO", "AMS", "VY4840", 260},
                        {"MAD", "FRA", "BA8982", 171},
                        {"IST", "LHR", "U23526", 254},
                        {"FRA", "MAD", "BA6773", 157},
                        {"CDG", "CPH", "IB5257", 299},
                        {"CPH", "CDG", "LH8545", 230},
                        {"LHR", "AMS", "IB4737", 110},
                        {"BCN", "MAD", "LH5496", 293},
                        {"CDG", "LHR", "U29718", 103},
                        {"LHR", "AMS", "BA9561", 253},
                        {"FRA", "LHR", "TK3167", 118},
                        {"IST", "FRA", "FR4727", 108},
                        {"CPH", "IST", "LH6320", 115},
                        {"LHR", "AMS", "BA6657", 122},
                        {"LHR", "FRA", "TK5342", 295},
                        {"IST", "LHR", "IB4938", 226},
                        {"CDG", "BCN", "VY9791", 289},
                        {"MAD", "LHR", "IB4124", 272},
                        {"FRA", "MAD", "BA7842", 121},
                        {"AMS", "FCO", "VY5092", 178},
                        {"CDG", "LHR", "BA9813", 171},
                        {"FRA", "IST", "BA2421", 226},
                        {"IST", "CPH", "U28059", 262},
                        {"MAD", "AMS", "LH7260", 191},
                        {"CDG", "CPH", "TK2044", 186}})
                .map(row -> new Flight((String) row[0], (String) row[1], (String) row[2], (Integer) row[3]))
                .collect(Collectors.toList());
    }
}
