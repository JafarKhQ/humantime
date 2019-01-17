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
  protected void initTimeUnits(Map<Integer, String> timeUnits) {
    timeUnits.put(YEAR, "%d years");
    timeUnits.put(MONTH, "%d months");
    timeUnits.put(WEEK, "%d weeks");
    timeUnits.put(DAY, "%d days");
    timeUnits.put(HOUR, "%d hours");
    timeUnits.put(MINUTE, "%d minutes");
    timeUnits.put(SECOND, "%d seconds");
  }
}
