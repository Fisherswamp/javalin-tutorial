package com.javalin_test.backend.startup;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.javalin_test.backend.modules.MainModule;
import com.javalin_test.backend.startup.entrypoint.EntrypointType;

public class Main {

  public static void main(String[] args) {
    final Injector injector = Guice.createInjector(new MainModule());
    injector.getInstance(Startup.class).boot(EntrypointType.REST, args);
  }
}
