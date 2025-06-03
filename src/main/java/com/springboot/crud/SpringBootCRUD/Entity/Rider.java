package com.springboot.crud.SpringBootCRUD.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Data
@Table(name = "rider")
public class Rider {
    @Id
    private Long id;
    private String riderCode;
    private String riderDesc;
    private Long riderPT;
    private Long riderPPT;
}
