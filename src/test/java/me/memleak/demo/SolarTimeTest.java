package me.memleak.demo;

import org.junit.Test;

public class SolarTimeTest extends CommonTimeTest<SolarTime> {

  @Override
  Class<SolarTime> getClazz() {
    return SolarTime.class;
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidInput() {
    timeConverter.applyTo(-1);
  }

  @Test
  public void zero() {
    testWithParams(0, "No Time.");
  }

  @Test
  public void pluto() {
    testWithParams(19_680, "1 Pluto");
    testWithParams(30 * 19_680, "30 Pluto");
  }

  @Test
  public void example() {
    // Sorry but we have Mars :D
    testWithParams(1_967, "2 Mars 1 Venus 87 seconds");

    // See told you
    testWithParams((3 * 499) + 360 + 110, "2 Mars 1 Venus 87 seconds");
  }
}
