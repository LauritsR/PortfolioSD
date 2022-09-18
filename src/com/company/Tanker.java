package com.company;

import java.util.Arrays;

public class Tanker extends Vessel {
    int[] amountOfCompartmentsList;
    int maxLitersOfLiquid = 1000000;
    public Tanker(String flagNation, int draft, int length, int width, int amountOfCompartments){
        super(flagNation, draft, length, width);
        if (amountOfCompartments > 10 || amountOfCompartments <= 0) {
            throw new IllegalArgumentException("Number not allowed: " + amountOfCompartments);
        } else {
            amountOfCompartmentsList = new int[amountOfCompartments];
            Arrays.fill(amountOfCompartmentsList, 0);
        }
        // uses super for using the constructor from the super / parent class
        // checks if the amount of compartments is valid, if not throws an exception
        // if true it creates a list the length of the given amount
        // 0 is empty, 1 is full. By default, everything is empty

    }

    public boolean loadingCargo(int whichTank, int amountOfLiquid){
        try {
            if (amountOfLiquid <= 0) {
                System.out.println("Not possible to fill 0 or a negative amount of liquid. You said " + amountOfLiquid);
                System.out.println();
                return false;
            } else if (amountOfCompartmentsList[whichTank] == maxLitersOfLiquid) {
                System.out.println(whichTank + " is already filled");
                System.out.println();
                return false;
            }
            if (amountOfCompartmentsList[whichTank] != maxLitersOfLiquid && amountOfLiquid + amountOfCompartmentsList[whichTank] < maxLitersOfLiquid) {
                amountOfCompartmentsList[whichTank] += amountOfLiquid;
                System.out.println("*filling " + amountOfLiquid + "L*");
                System.out.println("Tank " + whichTank + " is filled with " + amountOfCompartmentsList[whichTank] + "L");
                System.out.println();
                return true;
            } else {
                System.out.println("Not possible to fill " + amountOfLiquid + "L in the tank. Current amount of liquid is " + amountOfCompartmentsList[whichTank] + "L" );
                System.out.println("Remaining space is: " + (maxLitersOfLiquid - amountOfCompartmentsList[whichTank]) + "L");
                System.out.println();
                return false;
            }
        } catch (Exception ArrayIndexOutOfBoundsException) {
            // catches the error, if you write an array index out of bounds
            System.out.println("There is no tank at this index: " + whichTank);
            System.out.println();
            return false;
        }

    };

    void utilityLevelOfCapacity() {
        System.out.println("Getting the statistics from the tanker from " + flagNation + " which has " + amountOfCompartmentsList.length + " tanks");
        for (int i = 0; i < amountOfCompartmentsList.length; i++) {
            if (amountOfCompartmentsList[i] != 0) {
                double percentage = ((double) amountOfCompartmentsList[i] / maxLitersOfLiquid) * 100;
                System.out.println("Tank " + (i + 1) + " is filled with " + amountOfCompartmentsList[i] + "L." + " Which is " + percentage + "%");
            }
        }
        System.out.println("These tanks are empty:");
        for (int i = 0; i < amountOfCompartmentsList.length; i++) {
            if (amountOfCompartmentsList[i] == 0) {
                System.out.print((i+1) + " ");
            }
        }
        System.out.println();
        System.out.println("The max amount of liquid allowed is " + maxLitersOfLiquid);
        System.out.println();
    }

    int getLiquidInTank(int whichTank){
        return amountOfCompartmentsList[whichTank];
    }

}
