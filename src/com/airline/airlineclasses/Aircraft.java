package com.airline.airlineclasses;

import java.io.Serializable;

public abstract class Aircraft implements Serializable {
   private String modelName="";
   private int year;
   private int range;

    public Aircraft(String modelName, int year, int range){
        this.modelName = modelName;
        this.year = year;
        this.range = range;

    }

   public int countRange (Aircraft[] air) {
        int totalRange = 0;
        for (Aircraft i : air) {
            totalRange += i.getRange();
        }
        return totalRange;

    }

    public String getName(){
       return this.modelName;
    }

    public int getYear(){
        return this.year;
    }

    public int getRange(){
        return this.range;
    }

    public void setName(String newName){ modelName = newName;}

    public void setYear(int newYear){
        year = newYear;
    }

    public void setRange(int newRange){
        range = newRange;
    }

    }

