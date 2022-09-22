package com.company;

import com.company.Tanker;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TankerTest {
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
              Tanker tanker = new Tanker("test", 10, 0, 10, 2);
          });
    } // SOME OF THESE SHOULD BE UNDER VESSEL TEST

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
  }
