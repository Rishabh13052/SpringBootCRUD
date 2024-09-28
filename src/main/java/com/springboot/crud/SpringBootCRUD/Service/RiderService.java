package com.springboot.crud.SpringBootCRUD.Service;

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
}
