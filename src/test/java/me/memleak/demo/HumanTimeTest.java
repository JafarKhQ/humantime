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
    humanTime.applyTo(-1);
  }

  @Test
  public void zero() {
    String result = humanTime.applyTo(0);
    assertThat(result).isEqualTo("No Time.");
  }

  @Test
  public void seconds() {
    String result = humanTime.applyTo(59);
    assertThat(result).isEqualTo("59 seconds");

    result = humanTime.applyTo(1);
    assertThat(result).isEqualTo("1 seconds");
  }

  @Test
  public void minutes() {
    String result = humanTime.applyTo(60);
    assertThat(result).isEqualTo("1 minutes");

    result = humanTime.applyTo(60 * 59);
    assertThat(result).isEqualTo("59 minutes");
  }

  @Test
  public void days() {
    String result = humanTime.applyTo(24 * 60 * 60);
    assertThat(result).isEqualTo("1 days");

    result = humanTime.applyTo(6 * 24 * 60 * 60);
    assertThat(result).isEqualTo("6 days");

    result = humanTime.applyTo(4 * 24 * 60 * 60);
    assertThat(result).isEqualTo("4 days");
  }

  @Test
  public void weeks() {
    String result = humanTime.applyTo(7 * 24 * 60 * 60);
    assertThat(result).isEqualTo("1 weeks");

    result = humanTime.applyTo(14 * 24 * 60 * 60);
    assertThat(result).isEqualTo("2 weeks");
  }

  @Test
  public void months() {
    String result = humanTime.applyTo(30 * 24 * 60 * 60);
    assertThat(result).isEqualTo("1 months");

    result = humanTime.applyTo(60 * 24 * 60 * 60);
    assertThat(result).isEqualTo("2 months");
  }

  @Test
  public void someTimeInLife() {
    String result = humanTime.applyTo(4_147_205);
    assertThat(result).isEqualTo("1 months 2 weeks 4 days 5 seconds");

    result = humanTime
        .applyTo((30 * 24 * 60 * 60) + (14 * 24 * 60 * 60) + (4 * 24 * 60 * 60) + 5);
    assertThat(result).isEqualTo("1 months 2 weeks 4 days 5 seconds");
  }
}
