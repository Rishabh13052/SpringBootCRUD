package com.springboot.crud.SpringBootCRUD.ServiceImpl;

import com.springboot.crud.SpringBootCRUD.Entity.Rider;
import com.springboot.crud.SpringBootCRUD.Repository.RiderRepository;
import com.springboot.crud.SpringBootCRUD.Service.RiderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
public class RiderServiceImpl implements RiderService {
    @Autowired
    private RiderRepository riderRepository;


    @Override
    public Rider addRider(Rider rider) {
        return riderRepository.save(rider);
    }

    @Override
    public void deleteRider(Long id) {
        riderRepository.deleteById(id);
    }

    @Override
    public Rider updateRider(Long id, Rider rider) {
        log.info("rider details are :: {}",riderRepository.findById(id));
        //we haven't used optional.ofNullable because riderRepository.findById(id) gives empty as result not null
        Optional<Rider> currentRider = riderRepository.findById(id);
        if(currentRider.isPresent()){
            currentRider.get().setRiderCode(rider.getRiderCode());
            currentRider.get().setRiderDesc(rider.getRiderDesc());
            currentRider.get().setRiderPPT(rider.getRiderPPT());
            currentRider.get().setRiderPT(rider.getRiderPT());
            log.info("Updated Rider details are :: {}", currentRider.get());
            return riderRepository.save(currentRider.get());
        } else {
            log.info("Rider Id not present, hence adding new rider :: {}", rider);
            rider.setId(id);
            return riderRepository.save(rider);
        }
    }

    @Override
    public void deleteAllRider() {
        riderRepository.deleteAll();
    }

    @Override
    public Rider getRiderById(Long id) {
        return riderRepository.findById(id).get();
    }

    @Override
    public List<Rider> getAllRider() {
        return riderRepository.findAll();
    }

    @Override
    public List<Rider> getUpdatedRidersList(){
        List<Rider> riderList = riderRepository.findAll()
                .stream()
                .filter(rider -> ! rider.getRiderCode().equalsIgnoreCase("L188A01") && ! rider.getRiderCode().equalsIgnoreCase("L191A01"))
                .collect(Collectors.toList());
        log.info("Rider List :: {}", riderList);
        return riderList;
    }

}
