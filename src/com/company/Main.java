package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Tanker tankerOne = new Tanker("Denmark", 10, 10, 10, 10);
        tankerOne.loadingCargo(0, 1000);
        //System.out.println(tanker.getLiquidInTankConverted(0) + "L");
        tankerOne.loadingCargo(0, 5000);
        //System.out.println(tanker.getLiquidInTankConverted(0) + "L");
        tankerOne.loadingCargo(0, 1000000);
        tankerOne.loadingCargo(0, 100000);
        tankerOne.loadingCargo(11, 1000);
        tankerOne.loadingCargo(1, 0);
        tankerOne.loadingCargo(1, -3000);
        tankerOne.loadingCargo(1, 5000);
        tankerOne.loadingCargo(5, 55400);
        tankerOne.loadingCargo(6, 999999);

        tankerOne.utilityLevelOfCapacity();

    }
}
