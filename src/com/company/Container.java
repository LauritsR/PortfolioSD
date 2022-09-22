package com.company;

public class Container extends Vessel {
    int containerCapacity;
    int loadedAmountOfContainers = 0;
    int maxAmountOfContainers = 15000;
    public Container(String flagNation, int draft, int length, int width, int containerCapacity){
        super(flagNation, draft, length, width);
        if (containerCapacity < 0) {
            throw new IllegalArgumentException("Cannot sail with a negative capacity of containers");
        } else if (containerCapacity>maxAmountOfContainers) {
            throw new IllegalArgumentException("Cannot sail more than 15000 containers");
        }
        this.containerCapacity = containerCapacity;
    }

    boolean loadingCargo(int amountOfContainersToLoad){
        if (amountOfContainersToLoad <= 0) {
            System.out.println("Not possible to load negative or zero containers. You said: " + amountOfContainersToLoad);
            return false;
        } else if (amountOfContainersToLoad > containerCapacity-loadedAmountOfContainers) {
            System.out.println("There is not capacity for " + amountOfContainersToLoad + " container" + (amountOfContainersToLoad==1? "" : "s"));
            System.out.println("There is loaded " + loadedAmountOfContainers + " containers");
            System.out.println("The limit of containers is " + containerCapacity);
            return false;
        } else {
            loadedAmountOfContainers += amountOfContainersToLoad;
            System.out.println("*Loading " + amountOfContainersToLoad + " container" + (amountOfContainersToLoad==1? "" : "s") + "*");
            return true;
        }
    }

    void utilityLevelOfCapacity() {

    }
}
