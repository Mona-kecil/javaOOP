package service;

import entity.User;
import repository.UserLoginRepository;

public class UserLoginServiceImpl implements UserLoginService {
    
    private UserLoginRepository userLoginRepository;

    public UserLoginServiceImpl(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    public void login(User user) {
        if(isCredentialCorrect(user.getUsername(), user.getPassword())) {
            userLoginRepository.login(user);
            System.out.println("Login Success");
        }
        else {
            System.out.println("Login Failed");
        }
    }

    public void signup(User user) {
        if (isUsernameUnique(user.getUsername())) {
            if (isPasswordValid(user.getPassword())) {
                userLoginRepository.signup(user);
                System.out.println("Signup Success");
            }
        } else {
            System.out.println("Signup Failed");
        }
    }

    private boolean isUsernameUnique(String username) {
        if (isUsernameValid(username)) {
            for (var user : userLoginRepository.getUsers()) {
                if (user.getUsername().equals(username)) {
                    System.out.println("Username is not unique");
                    return false;
                }
            }
            System.out.println("Username is unique");
            return true;
        }
        return false;

    }

    private boolean isUsernameValid(String username) {
        if (username.length() >= 5 && username.length() <= 20) {
            System.out.println("Username is valid");
            return true;
        } else {
            System.out.println("Username is invalid");
            return false;
        }
    }

    private boolean isPasswordValid(String password) {
        if (password.length() >= 8 && password.length() <= 20) {
            System.out.println("Password is valid");
            return true;
        } else {
            System.out.println("Password is invalid");
            return false;
        }
    }

    private boolean isCredentialCorrect(String username, String password) {
        if (isPasswordValid(password)) {
            for (var user : userLoginRepository.getUsers()) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("Credential is correct");
                    return true;
                }
            }
        }
        System.out.println("Credential is incorrect");
        return false;
    }
}