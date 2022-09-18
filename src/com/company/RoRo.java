package com.company;

public class RoRo extends Vessel {
    int carLenghtMeters = 8;
    int truckLenghtMeters = 30;
    int laneMeters;

    public RoRo(String flagNation, int draft, int length, int width, int laneMeters){
        super(flagNation, draft, length, width);
        this.laneMeters = laneMeters;
    }

    public void loadingCargo() {
    }
}
