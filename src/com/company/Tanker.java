package com.company;

public class Tanker extends Vessel {
    int amountOfCompartments;

    public Tanker(String flagNation, int draft, int lenght, int width, int amountOfCompartments){
        super(flagNation, draft, lenght, width);
        this.amountOfCompartments = amountOfCompartments;
    }

    void loadingCargo(){

    };
}
