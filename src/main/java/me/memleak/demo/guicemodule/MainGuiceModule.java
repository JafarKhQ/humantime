package me.memleak.demo.guicemodule;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import me.memleak.demo.AbstractTimeConverter;
import me.memleak.demo.HumanTime;
import me.memleak.demo.SolarTime;

import static com.google.inject.name.Names.named;

public class MainGuiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(AbstractTimeConverter.class)
        .annotatedWith(named("humanTime"))
        .to(HumanTime.class)
        .in(Scopes.SINGLETON);

    bind(AbstractTimeConverter.class)
        .annotatedWith(named("solarTime"))
        .to(SolarTime.class)
        .in(Scopes.SINGLETON);
  }
}
