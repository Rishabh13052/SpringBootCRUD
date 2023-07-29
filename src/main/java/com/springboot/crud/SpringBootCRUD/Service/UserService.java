package com.springboot.crud.SpringBootCRUD.Service;

import com.springboot.crud.SpringBootCRUD.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public User addUser(User user);
    public String deleteUser(String userId);
    public User updateUser(String userId, User user);

    public User getUser(String userId);
    public List<User> getAllUser();

}
