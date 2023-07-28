package com.DriverPassenger.demo.repositories;

import com.DriverPassenger.demo.entities.Driver;
import com.DriverPassenger.demo.entities.Passenger;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {

    @Query(value = "select * from passenger " +
            "where active = :active and " +
            "(:searchText is null or concat(first_name, concat(' ', last_name)) like :searchText)",
            countQuery = "select count(*) from passenger " +
                    "where active = :active and " +
                    "(:searchText is null or concat(first_name, concat(' ', last_name)) like :searchText)",
            nativeQuery = true)
    Slice<Passenger> search(@Param("active") Integer active, @Param("searchText") String searchText);

}
