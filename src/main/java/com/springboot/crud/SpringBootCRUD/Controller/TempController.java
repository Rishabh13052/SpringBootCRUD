package com.springboot.crud.SpringBootCRUD.Controller;

import com.springboot.crud.SpringBootCRUD.Entity.Rider;
import com.springboot.crud.SpringBootCRUD.ServiceImpl.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temp")
public class TempController {

    @Autowired
    private TempService tempService;
    @GetMapping("/getUpdatedRiderList")
    public List<Rider> getUpdatedRiderList(){
        return tempService.getUpdatedRidersList();
    }

    @GetMapping("/printUpdatedList")
    public void printUpdatedList(){
        tempService.printUpdatedList();
    }
}
