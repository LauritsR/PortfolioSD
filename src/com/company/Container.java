package com.company;

public class Container extends Vessel {
    private int containerCapacity;
    private int loadedAmountOfContainers = 0;
    private final int MAX_AMOUNT_OF_CONTAINERS = 15000;
    public Container(String flagNation, int draft, int length, int width, int containerCapacity){
        super(flagNation, draft, length, width);
        if (containerCapacity <= 0) {
            throw new IllegalArgumentException("Cannot sail with a negative capacity or zero of containers");
        } else if (containerCapacity>MAX_AMOUNT_OF_CONTAINERS) {
            throw new IllegalArgumentException("Cannot sail more than 15000 containers");
        }
        this.containerCapacity = containerCapacity;
    }

    public boolean loadingCargo(int amountOfContainersToLoad){
        if (amountOfContainersToLoad <= 0) {
            System.out.println("Not possible to load negative or zero containers. You said: " + amountOfContainersToLoad);
            System.out.println();
            return false;
        } else if (amountOfContainersToLoad > containerCapacity-loadedAmountOfContainers) {
            System.out.println("There is not capacity for " + amountOfContainersToLoad + " container" + (amountOfContainersToLoad==1? "" : "s"));
            System.out.println("There is loaded " + loadedAmountOfContainers + " containers");
            System.out.println("The limit of containers is " + containerCapacity);
            System.out.println();
            return false;
        } else {
            loadedAmountOfContainers += amountOfContainersToLoad;
            System.out.println("*Loading " + amountOfContainersToLoad + " container" + (amountOfContainersToLoad==1? "" : "s") + "*");
            System.out.println("There is loaded " + loadedAmountOfContainers + " container" + (amountOfContainersToLoad==1? "" : "s") + " in total");
            System.out.println();
            return true;
        }
    }
    @Override
    public double utilityLevelOfCapacity() {
        System.out.println("Getting info from container ship from " + flagNation);
        System.out.println("The ship is loaded with " + loadedAmountOfContainers + " containers out of " + containerCapacity + " containers");
        double utilityLevelOfCapacity = ((double) loadedAmountOfContainers / containerCapacity * 100);
        System.out.println("The ship is filled " + utilityLevelOfCapacity + "%");
        return utilityLevelOfCapacity;
    }
}
