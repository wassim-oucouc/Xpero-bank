package repository.implement;

import mapper.UserMapper;
import model.User;
import repository.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository{

    private UserMapper userMapper;


    public InMemoryUserRepository()
    {
        this.userMapper = new UserMapper();
    }



    HashMap<String, HashMap<String,Object>> userData = new HashMap<>();


    public User createUser(User user)
    {
        System.out.println(user.getPassword());
        HashMap<String,Object> newUser = new HashMap<>();
        newUser.put("Id",user.getId());
        newUser.put("Name",user.getFullName());
        newUser.put("Email",user.getEmail());
        newUser.put("Password",user.getPassword());
        newUser.put("Address",user.getAddress());
        userData.put(String.valueOf(user.getEmail()),newUser);
       return user;
    }

    public User updateUser(String email,User user)
    {
        HashMap<String,Object> userFound = userData.get(email);
        userFound.put("Email",user.getEmail());
        userFound.put("Address",user.getAddress());
        return user;
    }

    public void deleteUser(String email)
    {
        userData.remove(email);
        System.out.println("User Has been Removed with success");
    }
    public List<Object> getAllUsers()
    {
        Collection<HashMap<String, Object>> values = userData.values();
        return new ArrayList<>(values);
    }

    public Boolean checkUserByEmail(String email)
    {
        HashMap<String,Object> userFound = userData.get(email);
        if(userFound == null)
        {
            return true;
        }
            return false;


    }

    public User getUserByEmail(String email)
    {
        HashMap<String,Object> userFound = userData.get(email);
        System.out.println(this.userMapper.ToEntity(userFound));
        return this.userMapper.ToEntity(userFound);
    }

    public String checkEmailAndPassword(String email,String password)
    {
        HashMap<String,Object> userFound = userData.get(email) ;
        if(userFound != null)
        {
            if(userFound.get("Email").equals(email) && userFound.get("Password").equals(password))
            {
                return "User Authorized";
            }
            return "Email or Password incorrect";
        }
        return "User Not Exists";
    }

    public String updateEmailUser(String email, String newEmail) {
        if (userData.get(email) != null) {
            HashMap<String, Object> userFound = userData.get(email);
            userFound.put("Email", newEmail);
            System.out.println(userFound);
            return "email updated with success";
        }
        return "user is null";
    }
    public String updateaddresseUser(String email,String addresse)
    {
        if (userData.get(email) != null) {
            HashMap<String, Object> userFound = userData.get(email);
            userFound.put("Address",addresse);
            System.out.println(userFound);
            return "addresse updated with success";
        }
        return  "user is null";
    }

}
