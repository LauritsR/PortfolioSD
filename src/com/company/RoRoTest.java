package com.company;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoRoTest {

    @Test
    void throwsExceptionWhenLaneLengthZero() {
        assertThrows(IllegalArgumentException.class,
            () -> {
                RoRo RoRoOne = new RoRo("Denmark", 10, 10, 10, 0);
            });
    }

    @Test
    void throwsExceptionWhenLaneLengthNegative() {
        assertThrows(IllegalArgumentException.class,
            () -> {
                RoRo RoRoOne = new RoRo("Denmark", 10, 10, 10, -2);
            });
    }

    @Test
    void returnsTrueWhenLoadingCar(){
        RoRo RoRoOne = new RoRo("Denmark", 10, 10, 10, 60);
        assertTrue(RoRoOne.loadingCargo("car", 1));
    }

    @Test
    void returnsTrueWhenLoadingTruck(){
        RoRo RoRoOne = new RoRo("Denmark", 10, 10, 10, 60);
        assertTrue(RoRoOne.loadingCargo("truck", 1));
    }

    @Test
    void returnsTrueWhenLoadingUnderCapacityVehicles(){
        RoRo RoRoOne = new RoRo("Denmark", 10, 10, 10, 60);
        assertTrue(RoRoOne.loadingCargo("car", 1));
    }

    @Test
    void returnsTrueWhenLoadingMultipleVehicles(){
        RoRo RoRoOne = new RoRo("Denmark", 10, 10, 10, 60);
        assertTrue(RoRoOne.loadingCargo("car", 5));
    }

    @Test
    void returnsFalseWhenLoadingExactFilledAmountOfVehicles(){
        RoRo RoRoOne = new RoRo("Denmark", 10, 10, 10, 80);
        RoRoOne.loadingCargo("car", 10);
        assertFalse(RoRoOne.loadingCargo("car", 1));
    }

    @Test
    void returnsFalseWhenLoadingWrongTypeOfVehicle(){
        RoRo RoRoOne = new RoRo("Denmark", 10, 10, 10, 80);
        assertFalse(RoRoOne.loadingCargo("motorcycle", 1));
    }

    @Test
    void returnsFalseWhenLoadingZeroAmountOfVehicles(){
        RoRo RoRoOne = new RoRo("Denmark", 10, 10, 10, 80);
        assertFalse(RoRoOne.loadingCargo("car", 0));
    }

    @Test
    void returnsFalseWhenLoadingNegativeAmountOfVehicles(){
        RoRo RoRoOne = new RoRo("Denmark", 10, 10, 10, 80);
        assertFalse(RoRoOne.loadingCargo("car", -1));
    }

    @Test
    void returnsZeroWhenNoCarsAreFilled(){
        RoRo RoRoOne = new RoRo("Denmark", 10, 10, 10, 80);
        assertEquals(0, RoRoOne.utilityLevelOfCapacity());
    }

    @Test
    void returnsFiftyWhenHalfOfRoRoIsFilled(){
        RoRo RoRoOne = new RoRo("Denmark", 10, 10, 10, 160);
        RoRoOne.loadingCargo("car", 10);
        assertEquals(50, RoRoOne.utilityLevelOfCapacity());
    }
}