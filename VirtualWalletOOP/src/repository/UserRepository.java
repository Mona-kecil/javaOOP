package repository;

import java.util.ArrayList;

import entity.User;

public interface UserRepository {
    
    ArrayList<User> getAllUser();

    void register(User newUser);
    void login(User newUser);

    boolean isUsernameTaken(String username);
    boolean isUsernameExist(String username);
    boolean isPasswordCorrect(String username, String password);
}