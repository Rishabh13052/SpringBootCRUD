package com.springboot.crud.SpringBootCRUD.Client;

import com.springboot.crud.SpringBootCRUD.Entity.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserClient {
    List<String> listOfName = Arrays.asList("Rishabh", "Krishna", "Vishal");

    public List<User> getUsersByName(){

        return null;
    }
}
