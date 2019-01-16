package me.memleak.demo;

import static java.util.stream.Collectors.joining;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntBiFunction;

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

  public String applyTo(int input) {
    if (!isValidInput(input)) {
      throw new IllegalArgumentException("Invalid input");
    }

    if (input == 0) {
      return "No Time.";
    }

    AtomicInteger ai = new AtomicInteger(input);
    return TIMES_TEXT_MAP.entrySet().stream()
        .map(keyValue -> evaluate(ai.getAndUpdate(v -> v % keyValue.getKey()), keyValue))
        .filter(Objects::nonNull)
        .collect(joining(" "));
  }

  private String evaluate(int value, Entry<Integer, String> entry) {
    int amount = value / entry.getKey();
    if (amount <= 0) {
      return null;
    }

    return String.format(entry.getValue(), amount);
  }

  private boolean isValidInput(int input) {
    return input >= 0;
  }
}
