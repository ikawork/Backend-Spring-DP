package com.DriverPassenger.demo.services;

import com.DriverPassenger.demo.entities.Car;
import com.DriverPassenger.demo.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car getById(Long id) throws Exception{
        return carRepository.findById(id).orElseThrow(()-> new Exception("RECORD_NOT_FOUND"));
    }

}
