package com.company;

public class RoRo extends Vessel {
    private final int CAR_LENGTH_METERS = 8;
    private final int TRUCK_LENGTH_METERS = 30;
    private int laneMeters;
    private int addedLengthToCargo;
    private int amountOfCars;
    private int amountOfTrucks;
    private int totalAmountOfVehicles;

    public RoRo(String flagNation, int draft, int length, int width, int laneMeters){
        super(flagNation, draft, length, width);
        if (laneMeters == 0 || laneMeters < 0) {
            throw new IllegalArgumentException("Number not allowed: " + laneMeters);
        } else {
            this.laneMeters = laneMeters;
        }
        System.out.println(laneMeters);
    }



    public boolean loadingCargo(String carOrTruck, int amountOfVehicles) {
        int addLength = 0;
        if (amountOfVehicles <= 0) {
            System.out.println("Cannot load 0 or negative amount of vehicles. You said: " + amountOfVehicles);
            return false;
        }
        if (carOrTruck.equalsIgnoreCase("car")) {
            addLength = CAR_LENGTH_METERS;
        } else if (carOrTruck.equalsIgnoreCase("truck")) {
            addLength = TRUCK_LENGTH_METERS;
        } else {
            System.out.println("Input not recognized: " + carOrTruck + " - can only load trucks or cars. Write in singular (car or truck)");
            return false;
        }
        if (addLength*amountOfVehicles <= laneMeters && addedLengthToCargo < laneMeters) {
            System.out.println("Loading " + amountOfVehicles + " " + carOrTruck.toLowerCase() + "s");
            addedLengthToCargo += addLength*amountOfVehicles;
            System.out.println("There is added " + addedLengthToCargo + "m of vehicles");
            System.out.println();
            totalAmountOfVehicles += amountOfVehicles;
            if (carOrTruck.equalsIgnoreCase("car")) {
                amountOfCars += amountOfVehicles;
            } else {
                amountOfTrucks += amountOfVehicles;
            }
            return true;
        } else {
            System.out.println("There is not space for " + amountOfVehicles + " " + carOrTruck + (amountOfVehicles > 1 ? "s": "") );
            return false;
        }
    }
    @Override
    public double utilityLevelOfCapacity() {
        System.out.println("The RoRo from "+ flagNation);
        System.out.println("total length loaded " + addedLengthToCargo + "m");
        System.out.println("total amount of vehicles " + totalAmountOfVehicles);
        System.out.println("Amount of cars is " + amountOfCars);
        System.out.println("Amount of trucks is " + amountOfTrucks);
        double utilityLevelOfCapacity = ((double) addedLengthToCargo / laneMeters * 100);
        System.out.println("The RoRo is filled " + utilityLevelOfCapacity + "%");
        System.out.println();
        return utilityLevelOfCapacity;
    }
}
