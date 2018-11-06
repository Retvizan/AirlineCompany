package com.airline.airlineclasses;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Andrei_Shkarubski on 10/23/2018.
 */
public class AircraftData implements Serializable{

    private static String[] modelHelic = {"Mi-8", "Mi-6", "Mi-3", "K-57", "K37"};

    private static String[] modelPlane = {"TU134", "TU147", "A380", "B747", "IL62"};

    private static String[] modelQuad = {"Dj1", "Dj47", "Dj113", "Dj118", "Dj181"};

    private static int yearHelic[] = {1979, 1987, 1990, 1993, 1999};
    private static int yearPlane[] = {1984, 1991, 1999, 2001, 2007};
    private static int yearQuad[] = {2013, 2015, 2017, 2016, 2018};

    private static int rangeHelic[] = {350, 400, 470, 600, 700};
    private static int rangePlane[] = {2000, 3000, 3500, 4000, 7000};
    private static int rangeQuad[] = {10, 12, 14, 20, 24};

    private static int weightHelic[] = {1500, 2000, 3000, 1000, 1200};
    private static int capacityPlane[] = {150, 170, 200, 240, 300};
    private static int weightQuad[] = {1, 2, 5, 7, 9};

    public static void createAirline(ArrayList<Aircraft> airline){
            for(int i=0; i<modelPlane.length; i++){
            airline.add(new Helicopter(modelHelic[i], yearHelic[i], rangeHelic[i], weightHelic[i]));
            airline.add(new Plane(modelPlane[i],yearPlane[i],rangePlane[i], capacityPlane[i]));
            airline.add(new Quadrocopter(modelQuad[i],yearQuad[i],rangeQuad[i], weightQuad[i]));

        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {




        File dir = new File("d:\\AirlineData");
        if (dir.exists() == false) dir.mkdir();

        FileOutputStream out = new FileOutputStream("d:\\AirlineData\\data.txt");
        ObjectOutputStream objout = new ObjectOutputStream(out);

        ArrayList<Aircraft>belavia = new ArrayList<Aircraft>();
        createAirline(belavia);

        for (Aircraft i:belavia) {
            objout.writeObject(i);
            objout.flush();
        }



        objout.close();
        out.close();
    }
}