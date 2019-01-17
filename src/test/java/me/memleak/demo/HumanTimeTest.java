package me.memleak.demo;

import org.junit.Test;

public class HumanTimeTest extends CommonTimeTest<HumanTime> {

  @Override
  Class<HumanTime> getClazz() {
    return HumanTime.class;
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
  public void seconds() {
    testWithParams(1, "1 seconds");
    testWithParams(59, "59 seconds");
  }

  @Test
  public void minutes() {
    testWithParams(60, "1 minutes");
    testWithParams(60 * 59, "59 minutes");
  }

  @Test
  public void days() {
    testWithParams(24 * 60 * 60, "1 days");
    testWithParams(6 * 24 * 60 * 60, "6 days");
    testWithParams(4 * 24 * 60 * 60, "4 days");
  }

  @Test
  public void weeks() {
    testWithParams(7 * 24 * 60 * 60, "1 weeks");
    testWithParams(14 * 24 * 60 * 60, "2 weeks");
  }

  @Test
  public void months() {
    testWithParams(30 * 24 * 60 * 60, "1 months");
    testWithParams(2 * 30 * 24 * 60 * 60, "2 months");
  }

  @Test
  public void someTimeInLife() {
    testWithParams(4_147_205, "1 months 2 weeks 4 days 5 seconds");
    testWithParams((30 * 24 * 60 * 60) + (14 * 24 * 60 * 60) + (4 * 24 * 60 * 60) + 5,
        "1 months 2 weeks 4 days 5 seconds");
  }
}
