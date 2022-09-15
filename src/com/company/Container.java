package com.company;

public class Container extends Vessel {
    int numberOfContainers;
    public Container(String flagNation, int draft, int lenght, int width, int numberOfContainers){
        super(flagNation, draft, lenght, width);
        this.numberOfContainers = numberOfContainers;
    }

    void loadingCargo(){

    };
}
