package com.company;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class TankerTest {

  @Test
  void throwsExeptionWhenZero(){
      Tanker tanker = new Tanker("Denmark", 10, 10, 10, 10);
      assertThrows(IllegalArgumentException.class,
          () -> {
                tanker.loadingCargo(0, 0);
          });
  }
  @Test
  void throwsExeptionWhenNegative(){
      Tanker tanker = new Tanker("Denmark", 10, 10, 10, 10);
      assertThrows(IllegalArgumentException.class,
          () -> {
                tanker.loadingCargo(0, -0.2);
          });
  }
}