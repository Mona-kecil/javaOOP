package repository;

import java.util.ArrayList;

import entity.User;
import util.UserDataUtility;

public class UserRepositoryImpl implements UserRepository {
    
    public ArrayList<User> user = new ArrayList<User>(10);

    public ArrayList<User> getAllUser()
    {
        UserDataUtility.readUsers(user);
        return user;
    }

    public void register(User newUser) {
        if (isUsernameTaken(newUser.getUsername())) {
            return;
        }
        user.add(newUser);
    }

    public void login(User newUser) {
        if (isUsernameExist(newUser.getUsername())) {
            if (isPasswordCorrect(newUser.getUsername(), newUser.getPassword()))
                System.out.println("Login success");
            else
                System.out.println("Incorrect password");
        }
        else
            System.out.println("Username doesn't exist");
    }

    public boolean isUsernameTaken(String username) {
        for (var item : user) {
            if (item.getUsername().equals(username)) {
                System.out.println("Username already taken");
                return true;
            }
        }
        return false;
    }

    public boolean isUsernameExist(String username) {
        for (var item : user) {
            if (item.getUsername().equals(username)) {
                System.out.println("Username exist");
                return true;
            }
        }
        return false;
    }

    public boolean isPasswordCorrect(String username, String password) {
        for (var item : user)
        {
            if (item.getUsername().equals(username) && item.getPassword().equals(password))
                return true;
        }
        return false;
    }
}