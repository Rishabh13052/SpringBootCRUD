package com.springboot.crud.SpringBootCRUD.Repository;

import com.springboot.crud.SpringBootCRUD.DTO.OutRiderDto;
import com.springboot.crud.SpringBootCRUD.DTO.RiderDto;
import com.springboot.crud.SpringBootCRUD.Entity.Rider;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RiderRepository extends JpaRepository<Rider, Long> {

    @Query( value = "SELECT new com.springboot.crud.SpringBootCRUD.DTO.OutRiderDto (riderCode, riderDesc, riderPT) from Rider r where r.riderPT = ?1")
    List<OutRiderDto> getListOfRider(Long riderPt);

    @Modifying
    @Transactional
    @Query( value = "UPDATE Rider r set r.riderpt = :riderPt where r.rider_code = :riderCode", nativeQuery = true)
    int getUpdatedListOfRider(@Param("riderCode") String riderCode, @Param("riderPt") Long riderPt);

}
