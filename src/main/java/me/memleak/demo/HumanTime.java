package me.memleak.demo;

import java.util.Map;

public class HumanTime extends AbstractTimeConverter {
  private static final int SECOND = 1;
  private static final int MINUTE = 60 * SECOND;
  private static final int HOUR = 60 * MINUTE;
  private static final int DAY = 24 * HOUR;
  private static final int WEEK = 7 * DAY;
  private static final int MONTH = 30 * DAY;
  private static final int YEAR = 365 * DAY;

  @Override
  protected int timeUnitsCount() {
    return 7;
  }

  @Override
  protected void initTimeUnits(Map<Integer, String> timeUnites) {
    timeUnites.put(YEAR, "%d years");
    timeUnites.put(MONTH, "%d months");
    timeUnites.put(WEEK, "%d weeks");
    timeUnites.put(DAY, "%d days");
    timeUnites.put(HOUR, "%d hours");
    timeUnites.put(MINUTE, "%d minutes");
    timeUnites.put(SECOND, "%d seconds");
  }
}
