package com.lastminute.model;

/**
 * Created by kubiczek on 3/28/16.
 */
public class Passengers {
    private int adult;
    private int child;
    private int infant;

    public Passengers(int adult, int child, int infant) {
        this.adult = adult;
        this.child = child;
        this.infant = infant;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public int getInfant() {
        return infant;
    }

    public void setInfant(int infant) {
        this.infant = infant;
    }
}
