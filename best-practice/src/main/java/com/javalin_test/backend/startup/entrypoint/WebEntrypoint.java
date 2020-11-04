package com.javalin_test.backend.startup.entrypoint;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.get;

import com.google.inject.Inject;
import com.javalin_test.backend.config.Constants;
import com.javalin_test.backend.controllers.UserCreationController;
import com.javalin_test.backend.controllers.UserStatusController;
import io.javalin.Javalin;

public class WebEntrypoint implements AppEntrypoint {

  private final Javalin javalin;

  private final UserCreationController userCreationController;

  private final UserStatusController userStatusController;

  @Inject
  public WebEntrypoint(
      final Javalin javalin,
      final UserCreationController userCreationController,
      final UserStatusController userStatusController) {
    this.javalin = javalin;
    this.userCreationController = userCreationController;
    this.userStatusController = userStatusController;
  }

  @Override
  public void boot(String[] args) {
    javalin
        .routes(
            () -> {
              path(
                  Constants.MAIN_PATH,
                  () -> {
                    path(
                        Constants.USER_PATH,
                        () -> {
                          path(
                              Constants.USER_CREATION_PATH,
                              () -> post(this.userCreationController::createUser));
                          path(
                              Constants.USER_DELETION_PATH,
                              () -> delete(this.userCreationController::deleteUser));
                          path(
                              Constants.USER_EXISTS_PATH,
                              () -> get(this.userStatusController::doesUserExist));
                        });
                  });
            })
        .start();
  }
}
