package com.company;

import com.company.Container;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ContainerTest {
    @Test
    void throwsExceptionWhenZeroContainerCapacity(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Container containerTwo = new Container("Denmark", 10,10,10,0);
                });
    }

    @Test
    void throwsExceptionWhenNegativeContainerCapacity(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Container containerTwo = new Container("Denmark", 10,10,10,-2);
                });
    }

    @Test
    void throwsExceptionWhenOverMaxAmountOfContainersAllowed(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Container containerTwo = new Container("Denmark", 10,10,10,15001);
                });
    }

    @Test
    void returnFalseWhenLoadingZeroAmountOfContainers() {
        Container containerTwo = new Container("Denmark", 10,10,10,1500);
        assertFalse(containerTwo.loadingCargo(0));
    }

    @Test
    void returnFalseWhenLoadingNegativeAmountOfContainers() {
        Container containerTwo = new Container("Denmark", 10,10,10,1500);
        assertFalse(containerTwo.loadingCargo(-2));
    }

    @Test
    void returnFalseWhenLoadingOverCapacityContainers () {
        Container containerTwo = new Container("Denmark", 10,10,10,1500);
        containerTwo.loadingCargo(1500);
        assertFalse(containerTwo.loadingCargo(1));
    }

    @Test
    void returnTrueWhenLoadingUnderAmountOfContainers () {
        Container containerTwo = new Container("Denmark", 10,10,10,1500);
        assertTrue(containerTwo.loadingCargo(150));
    }
}