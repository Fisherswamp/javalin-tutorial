package com.javalintest.backend.managers;

import com.javalintest.backend.model.request.UserRequestModel;
import com.javalintest.backend.model.response.Result;
import com.javalintest.backend.model.response.UserExistsResult;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class UsersManager {

  private static final Logger logger = LoggerFactory.getLogger(UsersManager.class);

  private final Set<UserRequestModel> users;

  public UsersManager() {
    users = new HashSet<>();
  }

  public Result createUser(final UserRequestModel user) {
    if (users.contains(user)) {
      return new Result(405, "Email " + user.getEmail() + " already exists!");
    } else {
      users.add(user);
      return new Result(200, "Success");
    }
  }

  public Result deleteUser(final UserRequestModel userModel) {
    if (!users.contains(userModel)) {
      return new Result(405, "Email " + userModel.getEmail() + " does not exist");
    } else {
      users.remove(userModel);
      return new Result(200, "Success");
    }
  }

  public Result userExists(final UserRequestModel user) {
    return new UserExistsResult(200, "", users.contains(user));
  }
}
