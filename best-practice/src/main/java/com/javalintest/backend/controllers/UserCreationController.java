package com.javalintest.backend.controllers;

import com.javalintest.backend.config.Constants;
import com.javalintest.backend.managers.UsersManager;
import com.javalintest.backend.model.request.UserRequestModel;
import com.javalintest.backend.model.response.Result;
import io.javalin.http.Context;
import io.javalin.plugin.openapi.annotations.HttpMethod;
import io.javalin.plugin.openapi.annotations.OpenApi;
import io.javalin.plugin.openapi.annotations.OpenApiContent;
import io.javalin.plugin.openapi.annotations.OpenApiRequestBody;
import io.javalin.plugin.openapi.annotations.OpenApiResponse;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserCreationController extends UserController {

  private final UsersManager manager;

  @Inject
  public UserCreationController(final UsersManager manager) {
    this.manager = manager;
  }

  @OpenApi(
      summary = "Create user",
      operationId = "createUser",
      path = "/" + ROOT_PATH + Constants.USER_CREATION_PATH,
      method = HttpMethod.POST,
      tags = {"User"},
      requestBody = @OpenApiRequestBody(content = {@OpenApiContent(from = UserRequestModel.class)}),
      responses = {
        @OpenApiResponse(status = "201"),
        @OpenApiResponse(
            status = "400",
            content = {@OpenApiContent(from = Result.class)}),
        @OpenApiResponse(
            status = "404",
            content = {@OpenApiContent(from = Result.class)}),
        @OpenApiResponse(
            status = "405",
            content = {@OpenApiContent(from = Result.class)}),
        @OpenApiResponse(
            status = "409",
            content = {@OpenApiContent(from = Result.class)}),
        @OpenApiResponse(
            status = "412",
            content = {@OpenApiContent(from = Result.class)}),
      })
  public void createUser(final Context ctx) {
    final UserRequestModel userModel = validateBody(ctx, UserRequestModel.class);
    if (userModel == null) {
      return;
    }
    final Result result = manager.createUser(userModel);
    if (this.resultIsIn2xxAndHandle(result, ctx)) {
      ctx.status(201);
    }
  }

  @OpenApi(
      summary = "Delete user",
      operationId = "deleteUser",
      path = "/" + ROOT_PATH + Constants.USER_DELETION_PATH,
      method = HttpMethod.DELETE,
      tags = {"User"},
      requestBody = @OpenApiRequestBody(content = {@OpenApiContent(from = UserRequestModel.class)}),
      responses = {
        @OpenApiResponse(status = "200"),
        @OpenApiResponse(
            status = "405",
            content = {@OpenApiContent(from = Result.class)}),
      })
  public void deleteUser(final Context ctx) {
    final UserRequestModel userModel = validateBody(ctx, UserRequestModel.class);
    if (userModel == null) {
      return;
    }
    final Result result = manager.deleteUser(userModel);
    if (this.resultIsIn2xxAndHandle(result, ctx)) {
      ctx.status(200);
    }
  }
}
