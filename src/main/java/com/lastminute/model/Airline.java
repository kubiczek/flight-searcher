package com.lastminute.model;

/**
 * Created by kubiczek on 3/28/16.
 */
public class Airline {
    private String iata;
    private String name;
    private double infantPrice;

    public Airline(String iata, String name, double infantPrice) {
        this.iata = iata;
        this.name = name;
        this.infantPrice = infantPrice;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInfantPrice() {
        return infantPrice;
    }

    public void setInfantPrice(double infantPrice) {
        this.infantPrice = infantPrice;
    }
}
