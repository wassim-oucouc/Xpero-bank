package repository;

import model.User;

import java.util.List;

public interface UserRepository {


    public User createUser(User user);
    public User updateUser(String email,User user);
    public void deleteUser(String email);
    public List<Object> getAllUsers();
    public Boolean checkUserByEmail(String email);
    public String checkEmailAndPassword(String email,String password);
    public User getUserByEmail(String email);
    public String updateEmailUser(String email,String newEmail);
    public String updateaddresseUser(String email,String addresse);




}
