package me.memleak.demo;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HumanTime {

  private static final int SECOND = 1;
  private static final int MINUTE = 60 * SECOND;
  private static final int HOUR = 60 * MINUTE;
  private static final int DAY = 24 * HOUR;
  private static final int WEEK = 7 * DAY;
  private static final int MONTH = 30 * DAY;
  private static final int YEAR = 365 * DAY;
  private static final Map<Integer, String> TIMES_TEXT_MAP = new LinkedHashMap<>(6);

  static {
    TIMES_TEXT_MAP.put(YEAR, "%d years");
    TIMES_TEXT_MAP.put(MONTH, "%d months");
    TIMES_TEXT_MAP.put(WEEK, "%d weeks");
    TIMES_TEXT_MAP.put(DAY, "%d days");
    TIMES_TEXT_MAP.put(HOUR, "%d hours");
    TIMES_TEXT_MAP.put(MINUTE, "%d minutes");
    TIMES_TEXT_MAP.put(SECOND, "%d seconds");
  }

  public String inHumanTime(final int input) {
    if (!isValidInput(input)) {
      throw new IllegalArgumentException("Invalid input");
    }

    StringBuilder builder = new StringBuilder();
    if (input == 0) {
      builder.append("Zero Time.");
    }

    int remaining = input;
    Iterator<Entry<Integer, String>> ita = TIMES_TEXT_MAP.entrySet().iterator();
    while (ita.hasNext() && remaining > 0) {
      Map.Entry<Integer, String> keyval = ita.next();

      int amout = remaining / keyval.getKey();
      if (amout > 0) {
        builder.append(String.format(keyval.getValue(), amout));
        builder.append(" ");
      }

      remaining = remaining % keyval.getKey();
    }

    return builder.toString();
  }

  private boolean isValidInput(int input) {
    return input >= 0;
  }
}
