package com.springboot.crud.SpringBootCRUD.Repository;

import com.springboot.crud.SpringBootCRUD.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>
{
}
