package com.lastminute.model;

/**
 * Created by kubiczek on 3/28/16.
 */
public class Airport {
    private String iata;
    private String city;

    public Airport(String iata, String city) {
        this.iata = iata;
        this.city = city;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
