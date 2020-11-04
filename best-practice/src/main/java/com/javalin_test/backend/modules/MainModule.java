package com.javalin_test.backend.modules;

import com.google.inject.AbstractModule;
import com.javalin_test.backend.startup.Startup;

public class MainModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Startup.class);
    install(new JavalinExampleModule());
  }
}
