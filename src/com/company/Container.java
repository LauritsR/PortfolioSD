package com.company;

public class Container extends Vessel {
    int numberOfContainers;
    public Container(String flagNation, int draft, int length, int width, int numberOfContainers){
        super(flagNation, draft, length, width);
        if (numberOfContainers < 0) {
            throw new IllegalArgumentException("Cannot sail with negative amount of containers");
        }
        this.numberOfContainers = numberOfContainers;
    }

    void loadingCargo(){

    };
}
