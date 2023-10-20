package service;

import entity.User;
import repository.UserRepository;

public class UserServiceImpl implements UserService {
    
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String firstName, String lastName, String username, String password, String email) {
        User user = new User(username, password, email, firstName, lastName);
        userRepository.register(user);
    }

    public void authenticateUser(String username, String password) {
        User newUser = new User(username, password);
        userRepository.login(newUser);
    }
}
