package service;

import entity.User;

public interface UserLoginService {
    void login(User user);
    void signup(User user);
}
