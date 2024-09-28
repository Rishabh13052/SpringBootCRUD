package com.springboot.crud.SpringBootCRUD.Controller;

import com.springboot.crud.SpringBootCRUD.Entity.Rider;
import com.springboot.crud.SpringBootCRUD.Service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rider")
public class RiderController {

    @Autowired
    private RiderService riderService;

    @GetMapping("/getRider/{riderId}")
    Rider getRiderById(@PathVariable Long riderId){
        return riderService.getRiderById(riderId);
    }

    @PostMapping("/addRider")
    Rider addRider(@RequestBody Rider rider){
        return riderService.addRider(rider);
    }

    @DeleteMapping("/deleteRider/{riderId}")
    String deleteRider(@PathVariable Long riderId){
        Rider rider = riderService.getRiderById(riderId);
        riderService.deleteRider(riderId);
        return "Rider " + riderId + " with rider name " + rider.getRiderCode() + " deleted successfully";
    }

    @PutMapping("/updateRider/{riderId}")
    Rider updateRider(@PathVariable Long riderId, @RequestBody Rider rider){
        return riderService.updateRider(riderId, rider);
    }

    @GetMapping("/getAllRider")
    List<Rider> getAllRiders(){
        return riderService.getAllRider();
    }

    @GetMapping("/getUpdatedRiderList")
    public List<Rider> getUpdatedRiderList(){
        return riderService.getUpdatedRidersList();
    }

}
