package com.DriverPassenger.demo.controllers;

import com.DriverPassenger.demo.entities.Car;
import com.DriverPassenger.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/all",method = RequestMethod.GET,produces = {"application/json"})
    public List<Car> getAll(){ return carService.getAll(); }

    @RequestMapping(value = "{id}",method = RequestMethod.GET,produces = {"application/json"})
    public Car getById(@PathVariable Long id) throws Exception{
        return carService.getById(id);
    }



}
