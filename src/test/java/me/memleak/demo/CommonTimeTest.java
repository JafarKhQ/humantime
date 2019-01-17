package me.memleak.demo;

import static org.assertj.core.api.Assertions.assertThat;

class CommonTimeTest<T extends AbstractTimeConverter> {

  protected T timeConverter;

  void testWithParams(int input, String expected) {
    String result = timeConverter.applyTo(input);
    assertThat(result).isEqualTo(expected);
  }
}
