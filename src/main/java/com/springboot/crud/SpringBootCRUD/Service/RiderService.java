package com.springboot.crud.SpringBootCRUD.Service;

import com.springboot.crud.SpringBootCRUD.DTO.OutRiderDto;
import com.springboot.crud.SpringBootCRUD.DTO.RiderDto;
import com.springboot.crud.SpringBootCRUD.Entity.Rider;

import java.util.List;

public interface RiderService {
    Rider addRider(Rider rider);
    void deleteRider(Long id);
    Rider updateRider(Long id, Rider rider);
    void deleteAllRider();
    Rider getRiderById(Long id);
    List<Rider> getAllRider();

    List<Rider> getUpdatedRidersList();

    List<OutRiderDto> getListOfRider(Long riderPt);
    List<RiderDto> getUpdatedRiderDTO(String riderCode, Long riderPt);
}

