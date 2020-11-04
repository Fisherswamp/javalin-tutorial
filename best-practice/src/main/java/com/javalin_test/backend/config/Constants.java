package com.javalin_test.backend.config;

public final class Constants {

  public static final String MAIN_PATH = "api/";

  public static final String USER_PATH = "user/";

  public static final String USER_CREATION_PATH = "create";

  public static final String USER_DELETION_PATH = "delete";

  public static final String USER_EXISTS_PATH = "exists";

  public static final String VERSION = "1.0.0";

  public static final String TITLE = "Javalin Example API";

  public static final String DESCRIPTION =
      "This API is a fully working example to show how Javalin works";

  public static final String DEFAULT_CONFIG_TYPE = "application/json";

  public static final String HOST_IP = "0.0.0.0";

  public static final int PORT = 6600;

  public static final int SSL_PORT = 6700;

  private Constants() {}
}
