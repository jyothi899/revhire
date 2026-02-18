package org.com.rev_hire.dao;

import org.com.rev_hire.model.UserModel;

public interface UserDAO {
    boolean registerUser(UserModel user);

    UserModel loginUser(String email, String password);
}
