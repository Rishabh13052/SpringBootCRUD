package com.springboot.crud.SpringBootCRUD.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="user")
@Data
public class User {
    @Id
    private String username;

    private String email;

    private String password;

    private Timestamp create_time;
}
