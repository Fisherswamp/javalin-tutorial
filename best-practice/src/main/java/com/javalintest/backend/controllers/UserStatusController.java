package com.javalintest.backend.controllers;

import com.javalintest.backend.config.Constants;
import com.javalintest.backend.managers.UsersManager;
import com.javalintest.backend.model.request.UserRequestModel;
import com.javalintest.backend.model.response.Result;
import com.javalintest.backend.model.response.UserExistsResult;
import io.javalin.http.Context;
import io.javalin.plugin.openapi.annotations.HttpMethod;
import io.javalin.plugin.openapi.annotations.OpenApi;
import io.javalin.plugin.openapi.annotations.OpenApiContent;
import io.javalin.plugin.openapi.annotations.OpenApiRequestBody;
import io.javalin.plugin.openapi.annotations.OpenApiResponse;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserStatusController extends UserController {

  private final UsersManager manager;

  @Inject
  public UserStatusController(final UsersManager manager) {
    this.manager = manager;
  }

  @OpenApi(
      summary = "Check if user exists",
      operationId = "doesUserExist",
      path = "/" + ROOT_PATH + Constants.USER_EXISTS_PATH,
      method = HttpMethod.GET,
      tags = {"User"},
      requestBody = @OpenApiRequestBody(content = {@OpenApiContent(from = UserRequestModel.class)}),
      responses = {
        @OpenApiResponse(
            status = "200",
            content = {@OpenApiContent(from = UserExistsResult.class)}),
        @OpenApiResponse(
            status = "400",
            content = {@OpenApiContent(from = Result.class)})
      })
  public void doesUserExist(final Context ctx) {
    final UserRequestModel userModel = validateBody(ctx, UserRequestModel.class);
    if (userModel == null) {
      return;
    }
    final Result result = manager.userExists(userModel);
    ctx.status(result.getStatusCode());
    ctx.json(result);
  }
}
