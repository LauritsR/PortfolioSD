package com.company;

import java.util.Arrays;

public class Tanker extends Vessel {
    double[] amountOfCompartmentsList;
    public Tanker(String flagNation, int draft, int lenght, int width, int amountOfCompartments){
        super(flagNation, draft, lenght, width);
        if (amountOfCompartments > 10 || amountOfCompartments <= 0) {
            throw new IllegalArgumentException("Number not allowed: " + amountOfCompartments);
        } else {
            amountOfCompartmentsList = new double[amountOfCompartments];
            Arrays.fill(amountOfCompartmentsList, 0);
        }
        // uses super for using the constructor from the super / parent class
        // checks if the amount of compartments is valid, if not throws an exception
        // if true it creates a list the length of the given amount
        // 0 is empty, 1 is full. By default, everything is empty


    }

    public void loadingCargo(int whichTank, double amountOfLiquid){
        if (amountOfLiquid <= 0) {
            throw new IllegalArgumentException("Cannot fill negative or zero amount of liquid");
        }
        if (amountOfCompartmentsList[whichTank] == 1) {
            System.out.println(whichTank + " is already filled");
        }
        if (amountOfCompartmentsList[whichTank] != 1 && amountOfLiquid + amountOfCompartmentsList[whichTank] < 1) {
            amountOfCompartmentsList[whichTank] += amountOfLiquid;
            System.out.println(amountOfCompartmentsList[whichTank]);
            System.out.println("Amount of liquid in tank " + whichTank + " is " + amountOfCompartmentsList[whichTank]);
        } else {
            System.out.println("Not possible to fill " + amountOfCompartmentsList[whichTank] + " amount of liquid");
            System.out.println("Current amount of liquid in tank " + whichTank + " is " + amountOfCompartmentsList[whichTank]);
        }

    };

    double getLiquidInTank(int whichTank){
        return amountOfCompartmentsList[whichTank];
    }

}
