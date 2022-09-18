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
