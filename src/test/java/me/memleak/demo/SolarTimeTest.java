package me.memleak.demo;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolarTimeTest {

  private SolarTime solarTime;

  @Before
  public void setUp() {
    solarTime = new SolarTime();
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidInput() {
    solarTime.applyTo(-1);
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
    // Sorry bit we have Mars :D
    testWithParams(1_967, "2 Mars 1 Venus 87 seconds");

    // See told you
    testWithParams((3 * 499) + 360 + 110, "2 Mars 1 Venus 87 seconds");
  }

  private void testWithParams(int input, String expected) {
    String result = solarTime.applyTo(input);
    assertThat(result).isEqualTo(expected);
  }
}