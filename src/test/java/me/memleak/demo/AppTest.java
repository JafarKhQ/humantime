package me.memleak.demo;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

  App app;

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void seconds() {
    app = new App(59);
    String result = app.inHumanTime();
    assertThat(result).isEqualTo("59 seconds ");

    app = new App(1);
    result = app.inHumanTime();
    assertThat(result).isEqualTo("1 seconds ");
  }

  @Test
  public void minutes() {
    app = new App(60);
    String result = app.inHumanTime();
    assertThat(result).isEqualTo("1 minutes ");

    app = new App(60 * 59);
    result = app.inHumanTime();
    assertThat(result).isEqualTo("59 minutes ");
  }

  @Test
  public void days() {
    app = new App(24 * 60 * 60);
    String result = app.inHumanTime();
    assertThat(result).isEqualTo("1 days ");

    app = new App(6 * 24 * 60 * 60);
    result = app.inHumanTime();
    assertThat(result).isEqualTo("6 days ");

    app = new App(4 * 24 * 60 * 60);
    result = app.inHumanTime();
    assertThat(result).isEqualTo("4 days ");
  }

  @Test
  public void weeks() {
    app = new App(7 * 24 * 60 * 60);
    String result = app.inHumanTime();
    assertThat(result).isEqualTo("1 weeks ");

    app = new App(14 * 24 * 60 * 60);
    result = app.inHumanTime();
    assertThat(result).isEqualTo("2 weeks ");
  }

  @Test
  public void months() {
    app = new App(30 * 24 * 60 * 60);
    String result = app.inHumanTime();
    assertThat(result).isEqualTo("1 months ");

    app = new App(60 * 24 * 60 * 60);
    result = app.inHumanTime();
    assertThat(result).isEqualTo("2 months ");
  }

  @Test
  public void someTimeInLife() {
    app = new App(4_147_205);
    String result = app.inHumanTime();
    assertThat(result).isEqualTo("1 months 2 weeks 4 days 5 seconds ");

    app = new App((30 * 24 * 60 * 60) + (14 * 24 * 60 * 60) + (4 * 24 * 60 * 60) + 5);
    result = app.inHumanTime();
    assertThat(result).isEqualTo("1 months 2 weeks 4 days 5 seconds ");
  }

  @Test
  public void test() {
    assertThat(true).isTrue();
  }
}