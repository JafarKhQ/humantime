package me.memleak.demo;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class App {

  private final int input;

  public App(int input) {
    if (!isValidinput())
      throw new IllegalArgumentException("Invalid input");

    this.input = input;
  }

  public static void main(String[] args) {

  }

  public static final int SEC = 1;
  public static final int MIN = 60 * SEC;
  public static final int HOU = 60 * MIN;
  public static final int DAY = 24 * HOU;
  public static final int WEK = 7 * DAY;
  public static final int MONTH = 30 * DAY;
  public static final int YEAR = 365 * DAY;

  public static final Map<Integer, String> TIMES = new LinkedHashMap<>(6);

  static {
    TIMES.put(YEAR, "%d years");
    TIMES.put(MONTH, "%d months");
    TIMES.put(WEK, "%d weeks");
    TIMES.put(DAY, "%d days");
    TIMES.put(HOU, "%d hours");
    TIMES.put(MIN, "%d minutes");
    TIMES.put(SEC, "%d seconds");
  }

  public String inHumanTime() {
    int remaining = input;
    StringBuilder builder = new StringBuilder();
    if (remaining == 0) {
      builder.append("Zero Time.");
    }

    Iterator<Map.Entry<Integer, String>> ita = TIMES.entrySet().iterator();
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

  private boolean isValidinput() {
    return input >= 0;
  }
}


/*
More OO & refactor
move to github
*/
