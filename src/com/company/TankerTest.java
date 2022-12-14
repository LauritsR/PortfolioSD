package com.company;

import com.company.Tanker;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TankerTest {

    @Test
    void throwsExceptionWhenEmptyFlagnation(){
      assertThrows(IllegalArgumentException.class,
          () -> {
              Tanker tanker = new Tanker("", 10, 10, 10, 2);
          });
    }
    @Test
    void throwsExceptionWhenEmptyFlagnationString(){
      assertThrows(IllegalArgumentException.class,
          () -> {
              Tanker tanker = new Tanker("empty", 10, 10, 10, 2);
          });
    }

    @Test
    void throwsExceptionWhenDraftZero(){
      assertThrows(IllegalArgumentException.class,
          () -> {
              Tanker tanker = new Tanker("test", 0, 10, 10, 2);
          });
    }
    @Test
    void throwsExceptionWhenDraftNegative(){
      assertThrows(IllegalArgumentException.class,
          () -> {
              Tanker tanker = new Tanker("test", -2, 10, 10, 2);
          });
    }

    @Test
    void throwsExceptionWhenLengthZero(){
      assertThrows(IllegalArgumentException.class,
          () -> {
              Tanker tanker = new Tanker("test", 10, -2, 10, 2);
          });
    }

    @Test
    void throwsExceptionWhenLengthNegative(){
      assertThrows(IllegalArgumentException.class,
          () -> {
              Tanker tanker = new Tanker("test", 10, 0, 10, 2);
          });
    }
    @Test
    void throwsExceptionWhenWidthZero(){
      assertThrows(IllegalArgumentException.class,
          () -> {
              Tanker tanker = new Tanker("test", 10, 10, 0, 2);
          });
    }

    @Test
    void throwsExceptionWhenWidthNegative(){
      assertThrows(IllegalArgumentException.class,
          () -> {
              Tanker tanker = new Tanker("test", 10, 10, -2, 2);
          });
    }

    // It's not possible to create a vessel object since it's abstract
    // So I'm testing the superclass constructor in my tanker class

    @Test
    void returnsFalseWhenArrayIndexOutOfBoundsExceptionTryingToFillOutOfArrayAndIsCaught(){
        Tanker tanker = new Tanker("Denmark", 10, 10, 10, 5);
        assertFalse(tanker.loadingCargo(6,100));
    }


    @Test
    void throwsExceptionWhenZeroCompartments(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Tanker tanker = new Tanker("Denmark", 10, 10, 10, 0);
                });
    }
    @Test
    void throwsExceptionWhenNegativeCompartments(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Tanker tanker = new Tanker("Denmark", 10, 10, 10, -2);
                });
    }

  @Test
  void returnsFalseWhenFillingNegativeAmountOfLiquid() {
      Tanker tankerOne = new Tanker("Denmark", 10, 10, 10, 10);
      assertFalse(tankerOne.loadingCargo(1, -3000));
    }

  @Test
  void returnsFalseWhenFillingZeroAmountOfLiquid() {
      Tanker tankerOne = new Tanker("Denmark", 10, 10, 10, 10);
      assertFalse(tankerOne.loadingCargo(1, 0));
    }

    @Test
    void returnsTrueWhenFillingPositiveAmountOfLiquid() {
        Tanker tankerOne = new Tanker("Denmark", 10, 10, 10, 10);
        assertTrue(tankerOne.loadingCargo(1, 2));
    }

    @Test
    void returnsFalseWhenFillingPositiveAmountOfLiquidOverLimit() {
        Tanker tankerOne = new Tanker("Denmark", 10, 10, 10, 10);
        tankerOne.loadingCargo(1, 999999);
        assertFalse(tankerOne.loadingCargo(1, 2));
    }
    @Test
    void returnsFalseWhenFillingLimitAmountOfLiquid() {
        Tanker tankerOne = new Tanker("Denmark", 10, 10, 10, 10);
        tankerOne.loadingCargo(1, 1000000);
        assertFalse(tankerOne.loadingCargo(1, 1));
    }

    @Test
    void returnsZeroWhenNoTankIsFilled() {
        Tanker tankerOne = new Tanker("Denmark", 10, 10, 10, 10);
        assertEquals(0, tankerOne.utilityLevelOfCapacity());
    }

    @Test
    void returns50When5TanksAreFilled() {
        Tanker tankerOne = new Tanker("Denmark", 10, 10, 10, 10);
        tankerOne.loadingCargo(0,100000);
        tankerOne.loadingCargo(1,100000);
        tankerOne.loadingCargo(2,100000);
        tankerOne.loadingCargo(3,100000);
        tankerOne.loadingCargo(4,100000);
        assertEquals(50, tankerOne.utilityLevelOfCapacity());
    }


    // dummy tests
    @Test
    void getsLocationOfShip() {
        Tanker tankerOne = new Tanker("Denmark", 10, 10, 10, 10);
        assertNull(tankerOne.getLocation(false));
    }

    @Test
    void getAvailableShips() {
        Tanker tankerOne = new Tanker("Denmark", 10, 10, 10, 10);
        assertNull(tankerOne.listOfAvailableShips(false));
    }
    @Test
    void notifyCustomers(){
        Tanker tankerOne = new Tanker("Denmark", 10, 10, 10, 10);
        assertEquals("Hello customer",tankerOne.notifyCustomers());
    }
  }



