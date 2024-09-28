package com.springboot.crud.SpringBootCRUD.ServiceImpl;

import com.springboot.crud.SpringBootCRUD.DTO.RiderDto;
import com.springboot.crud.SpringBootCRUD.Entity.Rider;
import com.springboot.crud.SpringBootCRUD.Service.RiderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class TempService {
    @Autowired
    private RiderService riderService;

    public List<Rider> getUpdatedRidersList(){
        List<Rider> riderList = riderService.getAllRider()
                .stream()
                .filter(rider -> !rider.getRiderCode().equalsIgnoreCase("L188A01") && !rider.getRiderCode().equalsIgnoreCase("L191A01"))
                .collect(Collectors.toList());
        log.info("Rider List :: {}", riderList);
        return riderList;
    }

    public void printUpdatedList(){

        List<RiderDto> listOfRiderList = new ArrayList<>();

                riderService.getAllRider()
                .stream()
                .filter(rider -> !rider.getRiderCode().equalsIgnoreCase("L188B01") && !rider.getRiderCode().equalsIgnoreCase("L177A05"))
                .forEach(rider -> {
                    RiderDto riderDto = new RiderDto();
                    riderDto.setId(rider.getId());
                    riderDto.setRiderDesc(rider.getRiderDesc());
                    riderDto.setRiderCode(rider.getRiderCode());
                    riderDto.setRiderPPT(rider.getRiderPPT());
                    riderDto.setRiderPT(rider.getRiderPT());
                    listOfRiderList.add(riderDto);
                });

                log.info("listOfRiderList is :: {}", listOfRiderList);
    }
}
