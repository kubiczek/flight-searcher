package com.lastminute.model;

/**
 * Created by kubiczek on 3/28/16.
 */
public class Flight {
    private String origin;
    private String destination;
    private String airline;
    private long basePrice;

    public Flight(String origin, String destination, String airline, long basePrice) {
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.basePrice = basePrice;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(long basePrice) {
        this.basePrice = basePrice;
    }
}
