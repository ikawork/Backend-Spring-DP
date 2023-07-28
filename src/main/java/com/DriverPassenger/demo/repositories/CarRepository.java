package com.DriverPassenger.demo.repositories;

import com.DriverPassenger.demo.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

}
