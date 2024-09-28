package com.springboot.crud.SpringBootCRUD.Controller;

import com.springboot.crud.SpringBootCRUD.Entity.User;
import com.springboot.crud.SpringBootCRUD.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{userId}")
    public User getUser(@PathVariable("userId") String userId){
        User getUser=userService.getUser(userId);
        return getUser;
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody  User user){

        return userService.addUser(user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
        return "User is deleted";
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PutMapping("/updateUser/{userId}")
    public User updateUser(@PathVariable("userId") String userId, @RequestBody User user){
        return userService.updateUser(userId, user);
    }

    @GetMapping("/getUserByName")
    public List<User> getUserByName(){
        return userService.getUserByName();
    }


}
