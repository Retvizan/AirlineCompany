package com.airline.airlineclasses;

import java.io.Serializable;

public class Quadrocopter extends Aircraft implements Serializable{

    private int weight;

    public Quadrocopter(String modelName, int year, int range, int weight){
      super(modelName, year, range);
      this.weight=weight;

    }
    public int getWeight(){
        return weight;
    }

    public void setCargoWeight(int weight){
        this.weight=weight;

    }


}


