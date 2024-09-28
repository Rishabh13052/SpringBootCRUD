package com.springboot.crud.SpringBootCRUD.ServiceImpl;

import com.springboot.crud.SpringBootCRUD.Client.UserClient;
import com.springboot.crud.SpringBootCRUD.Entity.User;
import com.springboot.crud.SpringBootCRUD.Repository.UserRepository;
import com.springboot.crud.SpringBootCRUD.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserClient userClient;
    @Override
    public User addUser(User user) {
        user.setCreate_time(Timestamp.valueOf(LocalDateTime.now()));
        User user1=userRepository.save(user);
        return user1;
    }

    @Override
    public String deleteUser(String userId) {
        User user1=userRepository.findById(userId).get();
        if(user1==null){
            return userId +" doesn't exist";
        } else {
            userRepository.deleteById(userId);
            return userId + " is deleted";
        }
    }

    @Override
    public User updateUser(String userId, User user) {
        User user1=userRepository.findById(userId).get();
        if(user1==null){
            user.setCreate_time(Timestamp.valueOf(LocalDateTime.now()));
            this.userRepository.save(user);
            return user;
        } else{
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            user1.setCreate_time(Timestamp.valueOf(LocalDateTime.now()));
            userRepository.save(user1);
            return user1;
        }
    }

    @Override
    public User getUser(String userId) {
        User user1= userRepository.findById(userId).get();
        return user1;
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUser=userRepository.findAll();
        return allUser;
    }

    @Override
    public List<User> getUserByName() {
        List<String> listOfName = Arrays.asList("rishabh3", "rishabh4", "rishabh5", "rishabh6");
        List<User> usersByName = userRepository.getUserByName(listOfName);
        return usersByName;
    }
}
