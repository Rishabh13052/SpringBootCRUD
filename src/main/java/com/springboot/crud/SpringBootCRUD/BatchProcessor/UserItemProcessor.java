package com.springboot.crud.SpringBootCRUD.BatchProcessor;

import com.springboot.crud.SpringBootCRUD.Entity.User;
import org.springframework.batch.item.ItemProcessor;


public class UserItemProcessor implements ItemProcessor<User, User>{
    @Override
    public User process(User user) throws Exception {
        return user;
    }
}
