package com.company;

public class RoRo extends Vessel {
    int carLenghtMeters = 8;
    int truckLenghtMeters = 30;
    int laneMeters;

    public RoRo(String flagNation, int draft, int lenght, int width, int laneMeters){
        super(flagNation, draft, lenght, width);
        this.laneMeters = laneMeters;
    }

    public void loadingCargo(int dog) {

    }
}
