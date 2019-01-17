package me.memleak.demo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.joining;

public abstract class AbstractTimeConverter {
  private static final int DEFAULT_TIME_UNITS_COUNT = 13;

  private final Map<Integer, String> timeUnits;

  public AbstractTimeConverter() {
    timeUnits = new LinkedHashMap<>(timeUnitsCount());
    initTimeUnits(timeUnits);
  }

  protected abstract void initTimeUnits(Map<Integer, String> timeUnits);

  public String applyTo(int input) {
    if (!isValidInput(input)) {
      throw new IllegalArgumentException("Invalid input");
    }

    if (input == 0) {
      return "No Time.";
    }

    AtomicInteger ai = new AtomicInteger(input);
    return timeUnits.entrySet().stream()
        .map(keyValue -> evaluate(ai.getAndUpdate(v -> v % keyValue.getKey()), keyValue))
        .filter(Objects::nonNull)
        .collect(joining(timeDelimiter()));
  }

  protected int timeUnitsCount() {
    return DEFAULT_TIME_UNITS_COUNT;
  }

  protected String timeDelimiter() {
    return " ";
  }

  protected boolean isValidInput(int input) {
    return input >= 0;
  }

  private String evaluate(int value, Map.Entry<Integer, String> entry) {
    int amount = value / entry.getKey();
    if (amount <= 0) {
      return null;
    }

    return String.format(entry.getValue(), amount);
  }
}
