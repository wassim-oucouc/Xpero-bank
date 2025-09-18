package service;

import model.User;
import repository.UserRepository;

import java.util.UUID;

public class UserService {

    private UserRepository userRepository;


    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }



    public String updateEmailUser(String email,String newEmail)
    {
        return this.userRepository.updateEmailUser(email,newEmail);
    }
    public String updateAdresseUser(String email,String addresse)
    {
return this.userRepository.updateaddresseUser(email,addresse);
    }
}
