package com.lastminute.model;

/**
 * Created by kubiczek on 3/28/16.
 */
public class SearchResult {
    private String flightCode;
    private double totalPrice;

    public SearchResult(String flightCode, double totalPrice) {
        this.flightCode = flightCode;
        this.totalPrice = totalPrice;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
