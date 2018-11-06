package com.airline.comparator;

import com.airline.airlineclasses.Aircraft;

import java.util.Comparator;

public class RangeComparator implements Comparator<Aircraft> {

    public int compare(Aircraft o1, Aircraft o2){
        return o1.getRange()-o2.getRange();
    }

}
