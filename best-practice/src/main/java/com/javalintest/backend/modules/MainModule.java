package com.javalintest.backend.modules;

import com.google.inject.AbstractModule;
import com.javalintest.backend.startup.Startup;

public class MainModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Startup.class);
    install(new JavalinExampleModule());
  }
}
