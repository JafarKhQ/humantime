package me.memleak.demo;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;

import static org.assertj.core.api.Assertions.assertThat;

abstract class CommonTimeTest<T extends AbstractTimeConverter> {

  protected Injector injector;
  protected T timeConverter;

  abstract Class<T> getClazz();

  @Before
  public void setUp() {
    injector = Guice.createInjector(mockedGuiceModules());

    timeConverter = injector.getInstance(getClazz());
  }

  void testWithParams(int input, String expected) {
    String result = timeConverter.applyTo(input);
    assertThat(result).isEqualTo(expected);
  }

  /**
   * Other Tests can override and add mocks for other dependencies if needed
   *
   * @return AbstractModule
   */
  AbstractModule mockedGuiceModules() {
    return new AbstractModule() {
      @Override
      protected void configure() {

      }
    };
  }
}
