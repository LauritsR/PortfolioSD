package com.company;

public abstract class Vessel {
    String flagNation;
    float draft;
    int lenght;
    int width;
    public Vessel(String flagNation, int draft, int lenght, int width) {
        this.flagNation = flagNation;
        this.draft = draft;
        this.lenght = lenght;
        this.width = width;
    }
    abstract void loadingCargo();
}
