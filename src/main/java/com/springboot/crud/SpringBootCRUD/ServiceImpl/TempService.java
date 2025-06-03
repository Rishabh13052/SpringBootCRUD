package com.springboot.crud.SpringBootCRUD.ServiceImpl;

import com.springboot.crud.SpringBootCRUD.DTO.RiderDto;
import com.springboot.crud.SpringBootCRUD.DTO.TempRiderDto;
import com.springboot.crud.SpringBootCRUD.DTO.UserRiderDto;
import com.springboot.crud.SpringBootCRUD.Entity.Rider;
import com.springboot.crud.SpringBootCRUD.Service.RiderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
@Slf4j
public class TempService {
    @Autowired
    private RiderService riderService;

    String[] listOfRiderCode = {"L188B01", "L177A06", "L191A02", "L191D02"};

    public List<Rider> getUpdatedRidersList() {
        List<Rider> riderList = riderService.getAllRider()
                .stream()
                .filter(rider -> !rider.getRiderCode().equalsIgnoreCase("L188A01") && !rider.getRiderCode().equalsIgnoreCase("L191A01"))
                .collect(Collectors.toList());
        log.info("Rider List :: {}", riderList);
        return riderList;
    }

    public void printUpdatedList() {

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

    public void printUpdatedList1() {
        List<RiderDto> riderDtoList = new ArrayList<>();
        riderService.getAllRider()
                .stream()
                .filter(rider -> Arrays.stream(listOfRiderCode).noneMatch(rider.getRiderCode()::equalsIgnoreCase))
                .filter(rider -> rider.getRiderCode().startsWith("L177"))
                .forEach(rider -> {
                    RiderDto riderDto = new RiderDto();
                    riderDto.setId(rider.getId());
                    riderDto.setRiderDesc(rider.getRiderDesc());
                    riderDto.setRiderCode(rider.getRiderCode());
                    riderDto.setRiderPPT(rider.getRiderPPT());
                    riderDto.setRiderPT(rider.getRiderPT());
                    riderDtoList.add(riderDto);
                });
        log.info("listOfRiderList is :: {}", riderDtoList);
    }

    public UserRiderDto getUserRiderDto() {
        List<RiderDto> riderDtos = new ArrayList<>();
        List<UserRiderDto> userRiderDtos = new ArrayList<>();
        TempRiderDto tempRiderDto = new TempRiderDto();
        UserRiderDto userRiderDto1 = new UserRiderDto();

        List<Rider> listOfRider = riderService.getAllRider()
                .stream()
                .filter(rider -> rider.getRiderCode().startsWith("L177"))
                .collect(Collectors.toList());
        listOfRider.stream().forEach( rider ->{
             RiderDto riderDto = new RiderDto();
             riderDto.setId(rider.getId());
             riderDto.setRiderDesc(rider.getRiderDesc());
             riderDto.setRiderCode(rider.getRiderCode());
             riderDto.setRiderPPT(rider.getRiderPPT());
             riderDto.setRiderPT(rider.getRiderPT());
             riderDtos.add(riderDto);
         });
        log.info("Rider DTOs are :: {}",riderDtos);
        riderDtos.stream().forEach( RiderDto ->{
            UserRiderDto userRiderDto = new UserRiderDto();
            userRiderDto.setRiderDto(RiderDto);
            userRiderDto.setRiderApplicable(true);
            userRiderDtos.add(userRiderDto);
        });
        log.info("UserRider DTOs are :: {}",userRiderDtos);
        userRiderDto1 = userRiderDtos.get(0);

        tempRiderDto.setRiderDto(Optional.ofNullable(userRiderDto1).map(UserRiderDto :: getRiderDto).orElse(null));
        log.info("Temp RiderDto  is :: {}",tempRiderDto);
        AtomicInteger i = new AtomicInteger(1);
        List<TempRiderDto> listOfTempRiderDto = new ArrayList<>();
        userRiderDtos.stream()
                .forEach(userRider ->{
                    TempRiderDto tempRiderDto1 = new TempRiderDto();
                    tempRiderDto1.setRiderDto(Optional.ofNullable(userRider).map(UserRiderDto :: getRiderDto).orElse(null));
                    tempRiderDto1.setRiderDesc((i.getAndIncrement()) +"");
                    listOfTempRiderDto.add(tempRiderDto1);
                });
        log.info("Temp Rider dto's are :: {}",listOfTempRiderDto);

        return null;
    }
}
