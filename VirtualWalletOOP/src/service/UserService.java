package service;

public interface UserService {

    void registerUser(String firstName, String lastName, String username, String password, String email);
    void authenticateUser(String username, String password);
}