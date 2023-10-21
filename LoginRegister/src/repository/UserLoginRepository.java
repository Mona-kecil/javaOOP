package repository;

import java.util.ArrayList;

import entity.User;

public interface UserLoginRepository {
    
    ArrayList<User> getUsers();
    void login(User user);
    void signup(User user);

}
