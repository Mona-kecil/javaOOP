package test;

import entity.User;
import repository.UserLoginRepository;
import repository.UserLoginRepositoryImpl;
import service.UserLoginService;
import service.UserLoginServiceImpl;

public class UserLoginServiceTest {
    public static void main(String[] args) {
        testRegister();
    }

    public static void testLogin() {
        UserLoginRepository userLoginRepository = new UserLoginRepositoryImpl();
        UserLoginService userLoginService = new UserLoginServiceImpl(userLoginRepository);
        
        User newUser = new User("Admin", "123bbb123abcabc");
        userLoginRepository.signup(newUser);
        
        User invalidUser = new User("Admin", "123bbb223");
        userLoginService.login(newUser);
        userLoginService.login(invalidUser);
    }
    
    public static void testRegister() {
        UserLoginRepository userLoginRepository = new UserLoginRepositoryImpl();
        UserLoginService userLoginService = new UserLoginServiceImpl(userLoginRepository);
        
        
        User oldUser = new User("Admin", "123bbb123abcabc");
        userLoginRepository.signup(oldUser);

        User newUser = new User("Admin", "123bbb123abcabc");
        userLoginService.signup(newUser);
    }
}