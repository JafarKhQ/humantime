package me.memleak.demo;

import com.google.inject.Guice;
import com.google.inject.Injector;
import me.memleak.demo.guicemodule.MainGuiceModule;

import java.time.Clock;

public class App {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new MainGuiceModule());

    AbstractTimeConverter humanTime = injector.getInstance(HumanTime.class);
    AbstractTimeConverter solarTime = injector.getInstance(SolarTime.class);

    final int seconds = (int) (Clock.systemUTC().millis() % Integer.MAX_VALUE);

    System.out.println("The seconds: " + seconds + " is equal to");
    System.out.println("In Human Time: " + humanTime.applyTo(seconds));
    System.out.println("In Solar Time: " + solarTime.applyTo(seconds));
  }
}
