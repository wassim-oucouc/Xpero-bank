package mapper;

import model.User;

import java.util.HashMap;
import java.util.UUID;

public class UserMapper {


    public User ToEntity(HashMap<String,Object> userMap)
    {
        User user = new User();
        user.setId((UUID) userMap.get("Id"));
        user.setFullName((String) userMap.get("Name"));
        user.setEmail((String) userMap.get("Email"));
        user.setPassword((String) userMap.get("Password"));
        user.setAddress((String) userMap.get("Address"));

        return user;
    }
}
