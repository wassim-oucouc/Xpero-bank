package service;

import model.User;
import repository.UserRepository;

public class AuthService {

    public UserRepository userRepository;

    public AuthService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public  String RegisterUser(User user)
    {
        if(user != null)
        {
                this.userRepository.createUser(user);
                return "Success";

        }
        return "User is null";
    }
    public Boolean CheckEmailExists(String email)
    {
        if(this.userRepository.checkUserByEmail(email))
        {
            return true;
        }
        return false;
    }
    public String LoginUser(String email,String password)
    {
        return this.userRepository.checkEmailAndPassword(email,password);
    }

    public User GetUserByEmail(String email)
    {
        return this.userRepository.getUserByEmail(email);
    }
    public Boolean Logout()
    {
return true;
    }
}
