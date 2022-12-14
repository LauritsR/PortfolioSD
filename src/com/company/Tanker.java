package com.company;

import java.util.Arrays;

public class Tanker extends Vessel {
    private int[] amountOfCompartmentsList;
    private final int MAX_AMOUNT_OF_LIQUID = 1000000;
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
            } else if (amountOfCompartmentsList[whichTank] == MAX_AMOUNT_OF_LIQUID) {
                System.out.println("Tank " + (whichTank+1) + " is already filled");
                System.out.println();
                return false;
            }
            if (amountOfCompartmentsList[whichTank] != MAX_AMOUNT_OF_LIQUID && amountOfLiquid + amountOfCompartmentsList[whichTank] < MAX_AMOUNT_OF_LIQUID+1) {
                amountOfCompartmentsList[whichTank] += amountOfLiquid;
                System.out.println("*filling " + amountOfLiquid + "L*");
                System.out.println("Tank " + (whichTank + 1) + " is filled with " + amountOfCompartmentsList[whichTank] + "L");
                System.out.println();
                return true;
            } else {
                System.out.println("Not possible to fill " + amountOfLiquid + "L in the tank. Current amount of liquid is " + amountOfCompartmentsList[whichTank] + "L" );
                System.out.println("Remaining space is: " + (MAX_AMOUNT_OF_LIQUID - amountOfCompartmentsList[whichTank]) + "L");
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
    @Override
    public double utilityLevelOfCapacity() {
        int totalAmountOfLiquid = 0;
        int filledTanks = 0;
        System.out.println("Getting the statistics from the tanker from " + flagNation + " which has " + amountOfCompartmentsList.length + " tanks");
        for (int i = 0; i < amountOfCompartmentsList.length; i++) {
            if (amountOfCompartmentsList[i] != 0) {
                double percentage = ((double) amountOfCompartmentsList[i] / MAX_AMOUNT_OF_LIQUID) * 100;
                System.out.println("Tank " + (i + 1) + " is filled with " + amountOfCompartmentsList[i] + "L." + " Which is " + percentage + "% filled");
                totalAmountOfLiquid += amountOfCompartmentsList[i];
                filledTanks += 1;
            }
        }
        System.out.println("These tanks are empty:");
        for (int i = 0; i < amountOfCompartmentsList.length; i++) {
            if (amountOfCompartmentsList[i] == 0) {
                System.out.print((i+1) + " ");
            }
        }
        System.out.println();
        System.out.println("The max amount of liquid allowed per tank is " + MAX_AMOUNT_OF_LIQUID);
        System.out.println("There is " + totalAmountOfLiquid + "L filled out of " + (MAX_AMOUNT_OF_LIQUID*amountOfCompartmentsList.length) + "L available space");
        double percentageAllTanks = ((double) totalAmountOfLiquid / (MAX_AMOUNT_OF_LIQUID*amountOfCompartmentsList.length)) * 100;
        System.out.println("The tanker is in total filled " + percentageAllTanks + "%");
        double utilityLevelOfCapacity = ((double) filledTanks / amountOfCompartmentsList.length * 100);
        System.out.println(utilityLevelOfCapacity + "% of the tanks have liquid");
        System.out.println();
        return utilityLevelOfCapacity;
    }


}
