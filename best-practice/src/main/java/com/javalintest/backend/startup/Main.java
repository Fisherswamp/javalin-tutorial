package com.javalintest.backend.startup;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.javalintest.backend.modules.MainModule;
import com.javalintest.backend.startup.entrypoint.EntrypointType;

public class Main {

  public static void main(String[] args) {
    final Injector injector = Guice.createInjector(new MainModule());
    injector.getInstance(Startup.class).boot(EntrypointType.REST, args);
  }
}
