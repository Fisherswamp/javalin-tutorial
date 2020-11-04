package com.javalin_test.backend.controllers;

import com.javalin_test.backend.config.Constants;

public abstract class UserController extends Controller {
  static final String ROOT_PATH = Controller.ROOT_PATH + Constants.USER_PATH;
}
