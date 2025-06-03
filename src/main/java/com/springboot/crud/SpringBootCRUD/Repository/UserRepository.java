package com.springboot.crud.SpringBootCRUD.Repository;

import com.springboot.crud.SpringBootCRUD.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String>
{
    @Query(value = "SELECT * FROM user u WHERE u.username IN ?1", nativeQuery = true)
    List<User> getUserByName(List<String> listOfName);
}
