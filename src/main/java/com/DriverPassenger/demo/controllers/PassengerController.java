package com.DriverPassenger.demo.controllers;

import com.DriverPassenger.demo.dto.AddPassenger;
import com.DriverPassenger.demo.entities.Passenger;
import com.DriverPassenger.demo.services.PassengerService;
import com.DriverPassenger.demo.utils.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/passenger")
@PreAuthorize("Role('ADMIN')")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @RequestMapping(value = "/all",method = RequestMethod.GET,produces = {"application/json"})
    public List<Passenger> getAll(){
        return passengerService.getAllPassenger();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = {"application/json"})
    public Passenger getById(@PathVariable Long id)throws Exception{
        return passengerService.getPassengerById(id);
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST,produces = {"application/json"})
    public Passenger add(@RequestBody AddPassenger addPassenger)throws Exception{
        GeneralUtil.checkRequiredProperties(addPassenger, Arrays.asList("firstName","lastName"));
        return passengerService.add(addPassenger);
    }

    public Passenger edit(@PathVariable Long id,@RequestBody AddPassenger addPassenger)throws Exception{
        GeneralUtil.checkRequiredProperties(addPassenger,Arrays.asList("firstName","lastName"));
        return passengerService.edit(id,addPassenger);
    }

}
