package me.memleak.demo;

import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class SolarTime extends AbstractTimeConverter {
  private static final int PLUTO = 19680;
  private static final int NEPTUNE = 14998;
  private static final int URANUS = 9575;
  private static final int SATURN = 4759;
  private static final int JUPITER = 2595;
  private static final int MARS = 760;
  private static final int EARTH = 499;
  private static final int VENUS = 360;
  private static final int MERCURY = 193;
  private static final int SECOND = 1;

  @Override
  protected int timeUnitsCount() {
    return 10;
  }

  @Override
  protected void initTimeUnits(Map<Integer, String> timeUnits) {
    timeUnits.put(PLUTO, "%d Pluto");
    timeUnits.put(NEPTUNE, "%d Neptune");
    timeUnits.put(URANUS, "%d Uranus");
    timeUnits.put(SATURN, "%d Saturn");
    timeUnits.put(JUPITER, "%d Jupiter");
    timeUnits.put(MARS, "%d Mars");
    timeUnits.put(EARTH, "%d Earth");
    timeUnits.put(VENUS, "%d Venus");
    timeUnits.put(MERCURY, "%d Mercury");
    timeUnits.put(SECOND, "%d seconds");
  }
}
