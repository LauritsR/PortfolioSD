package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Tanker tankerOne = new Tanker("bob", 10, 10, 10, 10);
        tankerOne.loadingCargo(0, 1000);
        tankerOne.loadingCargo(0, 5000);
        tankerOne.loadingCargo(0, 1000000);
        tankerOne.loadingCargo(0, 100000);
        tankerOne.loadingCargo(11, 1000);
        tankerOne.loadingCargo(1, 0);
        tankerOne.loadingCargo(1, -3000);
        tankerOne.loadingCargo(1, 5000);
        tankerOne.loadingCargo(5, 55400);
        tankerOne.loadingCargo(6, 1000000);
        tankerOne.loadingCargo(6, 2);
        tankerOne.loadingCargo(7, -2);
        tankerOne.utilityLevelOfCapacity();

        RoRo roroOne = new RoRo("Denmark", 10, 10,10,180);
        roroOne.loadingCargo("car", 5);
        roroOne.loadingCargo("truck", 2);
        roroOne.loadingCargo("car", 10);
        roroOne.loadingCargo("truck", 2);
        roroOne.loadingCargo("truck", -2);
        roroOne.loadingCargo("truck", 0);
        roroOne.loadingCargo("bob", 2);
        roroOne.utilityLevelOfCapacity();

        Container containerTwo = new Container("Denmark", 10,10,10,266);
        containerTwo.loadingCargo(98);
        containerTwo.loadingCargo(2);
        containerTwo.loadingCargo(4);
        containerTwo.loadingCargo(-2);
        containerTwo.loadingCargo(0);
        containerTwo.utilityLevelOfCapacity();



    }
}

// used material
// https://www.youtube.com/watch?v=vZm0lHciFsQ
// exception throw
