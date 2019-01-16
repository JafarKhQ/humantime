package me.memleak.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class HumanTimeTest {

  private HumanTime humanTime;

  @Before
  public void setUp() {
    humanTime = new HumanTime();
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidInput() {
    humanTime.inHumanTime(-1);
  }

  @Test
  public void seconds() {
    String result = humanTime.inHumanTime(59);
    assertThat(result).isEqualTo("59 seconds ");

    result = humanTime.inHumanTime(1);
    assertThat(result).isEqualTo("1 seconds ");
  }

  @Test
  public void minutes() {
    String result = humanTime.inHumanTime(60);
    assertThat(result).isEqualTo("1 minutes ");

    result = humanTime.inHumanTime(60 * 59);
    assertThat(result).isEqualTo("59 minutes ");
  }

  @Test
  public void days() {
    String result = humanTime.inHumanTime(24 * 60 * 60);
    assertThat(result).isEqualTo("1 days ");

    result = humanTime.inHumanTime(6 * 24 * 60 * 60);
    assertThat(result).isEqualTo("6 days ");

    result = humanTime.inHumanTime(4 * 24 * 60 * 60);
    assertThat(result).isEqualTo("4 days ");
  }

  @Test
  public void weeks() {
    String result = humanTime.inHumanTime(7 * 24 * 60 * 60);
    assertThat(result).isEqualTo("1 weeks ");

    result = humanTime.inHumanTime(14 * 24 * 60 * 60);
    assertThat(result).isEqualTo("2 weeks ");
  }

  @Test
  public void months() {
    String result = humanTime.inHumanTime(30 * 24 * 60 * 60);
    assertThat(result).isEqualTo("1 months ");

    result = humanTime.inHumanTime(60 * 24 * 60 * 60);
    assertThat(result).isEqualTo("2 months ");
  }

  @Test
  public void someTimeInLife() {
    String result = humanTime.inHumanTime(4_147_205);
    assertThat(result).isEqualTo("1 months 2 weeks 4 days 5 seconds ");

    result = humanTime
        .inHumanTime((30 * 24 * 60 * 60) + (14 * 24 * 60 * 60) + (4 * 24 * 60 * 60) + 5);
    assertThat(result).isEqualTo("1 months 2 weeks 4 days 5 seconds ");
  }
}
