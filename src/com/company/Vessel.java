package com.company;

import java.awt.*;
import java.util.ArrayList;

public abstract class Vessel {
    public String flagNation;
    public int draft;
    public int length;
    public int width;
    public Vessel(String flagNation, int draft, int length, int width) {
        if (draft <= 0 || length <= 0 || width <= 0)  {
            throw new IllegalArgumentException("Negative or zero found, not legal");
        }
        if (flagNation.isEmpty() || flagNation.equalsIgnoreCase("empty")) {
            throw new IllegalArgumentException("String cannot be empty");
        }
        this.flagNation = flagNation;
        this.draft = draft;
        this.length = length;
        this.width = width;
    }

    abstract public double utilityLevelOfCapacity();

    // The reason loading cargo is not set here, is because it takes different parameters


    // these next three are dummy text
    // they return null until next time
    public Point getLocation(boolean notifyCustomers) {
        if (notifyCustomers) {
            System.out.println(notifyCustomers());
        }
        return null;
    }

    public ArrayList<String> listOfAvailableShips(boolean notifyCustomers){
        if (notifyCustomers) {
            System.out.println(notifyCustomers());
        }
        return null;
    }

    public String notifyCustomers(){
        return "Hello customer";
    }
}
