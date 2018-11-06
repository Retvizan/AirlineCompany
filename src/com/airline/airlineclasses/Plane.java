package com.airline.airlineclasses;

import java.io.Serializable;

public class Plane extends Aircraft implements PassengerFlyable, Serializable{
    private int paxCapacity;


    public Plane(String modelName, int year, int range, int paxCapacity) {
       super(modelName, year, range);
        this.paxCapacity = paxCapacity;

    }

    @Override
    public void passFly() {
        System.out.println("Passengers are able to fly by a plane other means are not available for flying");
    }
}
