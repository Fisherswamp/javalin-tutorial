package com.javalin_test.backend.modules;

import com.google.inject.AbstractModule;
import com.javalin_test.backend.controllers.UserCreationController;
import com.javalin_test.backend.controllers.UserStatusController;
import com.javalin_test.backend.managers.UsersManager;

public class JavalinExampleModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(UsersManager.class);
    bind(UserCreationController.class);
    bind(UserStatusController.class);
    install(WebModule.create());
  }
}
