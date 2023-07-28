package com.DriverPassenger.demo.services;

import com.DriverPassenger.demo.dto.AddDriver;
import com.DriverPassenger.demo.entities.Car;
import com.DriverPassenger.demo.entities.Driver;
import com.DriverPassenger.demo.repositories.DriverRepository;
import com.DriverPassenger.demo.utils.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CarService carService;

    public List<Driver> getAllDriver(){return driverRepository.findAll();}
    public Driver getDriverById(Long id) throws Exception{
        return driverRepository.findById(id).orElseThrow(()->new Exception("RECORD_NOT_FOUND"));
    }

    @Transactional
    public Driver add(AddDriver addDriver)throws Exception{

        Driver driver = new Driver();
        driver.setCreateDate(new Date());
        GeneralUtil.getCopyOf(addDriver, driver);
        Car car = carService.getById(addDriver.getCarId());
        driver.setCar(car);
        return driverRepository.save(driver);

    }

    @Transactional
    public Driver edit(Long id, AddDriver addDriver) throws Exception {
        Driver driver = getDriverById(id);
        GeneralUtil.getCopyOf(addDriver, driver);
        if (addDriver.getCarId() != null && !addDriver.getCarId().equals(driver.getCar().getCarId())) {
            Car car = carService.getById(addDriver.getCarId());
            driver.setCar(car);
        }
        return driverRepository.save(driver);
    }


}
