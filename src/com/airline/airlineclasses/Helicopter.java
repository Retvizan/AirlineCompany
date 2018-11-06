package com.airline.airlineclasses;

import java.io.Serializable;

public class Helicopter extends Aircraft implements Serializable {


    private int cargoWeight;

    public Helicopter(String modelName, int year, int range, int cargoWeight){
       super(modelName, year, range);
        this.cargoWeight=cargoWeight;

    }
   public int getCargoWeight(){
        return cargoWeight;
   }

   public void setCargoWeight(int cargoWeight){
       this.cargoWeight=cargoWeight;

   }
}
