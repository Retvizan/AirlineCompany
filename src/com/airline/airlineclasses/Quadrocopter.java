package com.airline.airlineclasses;

import java.io.Serializable;

public class Quadrocopter extends Aircraft implements Serializable{

    private int cargoWeight;

    public Quadrocopter(String modelName, int year, int range, int cargoWeight){
      super(modelName, year, range);
      this.cargoWeight=cargoWeight;

    }


}


