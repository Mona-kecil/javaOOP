package repository;

import java.util.ArrayList;

import entity.User;

public class UserLoginRepositoryImpl implements UserLoginRepository {
    
    public ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public void login(User user) {
        // implement Session manager
        System.out.println("Sign in Success");
    }

    public void signup(User user) {
        users.add(user);
        System.out.println("Sign up Success");
    }
}
