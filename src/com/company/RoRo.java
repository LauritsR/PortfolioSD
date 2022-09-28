package com.company;

public class RoRo extends Vessel {
    public int carLengthMeters = 8;
    public int truckLengthMeters = 30;
    int laneMeters;

    public RoRo(String flagNation, int draft, int length, int width, int laneMeters){
        super(flagNation, draft, length, width);
        this.laneMeters = laneMeters;
    }

    public int addedLengthToCargo = 0;
    public int amountOfCars = 0;
    public int amountOfTrucks = 0;
    public int totalAmountOfVehicles = 0;

    public boolean loadingCargo(String carOrTruck, int amountOfVehicles) {
        int addLength = 0;
        if (amountOfVehicles <= 0) {
            System.out.println("Cannot load 0 or negative amount of vehicles. You said: " + amountOfVehicles);
            return false;
        }
        if (carOrTruck.equalsIgnoreCase("car")) {
            addLength = carLengthMeters;
        } else if (carOrTruck.equalsIgnoreCase("truck")) {
            addLength = truckLengthMeters;
        } else {
            System.out.println("Input not recognized: " + carOrTruck + " - can only load trucks or cars. Write in singular (car or truck)");
            return false;
        }
        if (addLength*amountOfVehicles < laneMeters && addedLengthToCargo < laneMeters) {
            System.out.println("Loading " + amountOfVehicles + " " + carOrTruck.toLowerCase() + "s");
            addedLengthToCargo += addLength*amountOfVehicles;
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
    public void utilityLevelOfCapacity() {
        System.out.println("The RoRo from "+ flagNation);
        System.out.println("total length loaded " + addedLengthToCargo + "m");
        System.out.println("total amount of vehicles " + totalAmountOfVehicles);
        System.out.println("Amount of cars is " + amountOfCars);
        System.out.println("Amount of trucks is " + amountOfTrucks);
        System.out.println("The RoRo is filled " + ((double) addedLengthToCargo / laneMeters * 100) + "%");
    }
}
