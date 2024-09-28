package com.springboot.crud.SpringBootCRUD.Repository;

import com.springboot.crud.SpringBootCRUD.Entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Long> {

}
