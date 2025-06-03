package com.springboot.crud.SpringBootCRUD.DTO;

import lombok.Data;

@Data
public class UserRiderDto {
    private RiderDto riderDto;
    private boolean isRiderApplicable;
}
