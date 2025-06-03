package com.springboot.crud.SpringBootCRUD.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OutRiderDto {
    private String riderCode;
    private String riderDesc;
    private Long riderPT;
}
