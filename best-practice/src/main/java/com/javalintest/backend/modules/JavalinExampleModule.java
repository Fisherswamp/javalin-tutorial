package com.javalintest.backend.modules;

import com.google.inject.AbstractModule;
import com.javalintest.backend.controllers.UserCreationController;
import com.javalintest.backend.controllers.UserStatusController;
import com.javalintest.backend.managers.UsersManager;

public class JavalinExampleModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(UsersManager.class);
    bind(UserCreationController.class);
    bind(UserStatusController.class);
    install(WebModule.create());
  }
}
