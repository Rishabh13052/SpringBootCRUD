package com.springboot.crud.SpringBootCRUD.DTO;

import lombok.Data;

@Data
public class RiderDto {
    private Long id;
    private String riderCode;
    private String riderDesc;
    private Long riderPT;
    private Long riderPPT;
}
