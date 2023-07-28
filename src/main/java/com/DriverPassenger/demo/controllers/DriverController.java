package com.DriverPassenger.demo.controllers;

import com.DriverPassenger.demo.dto.AddDriver;
import com.DriverPassenger.demo.entities.Driver;
import com.DriverPassenger.demo.services.DriverService;
import com.DriverPassenger.demo.utils.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/driver")
@PreAuthorize("Role('ADMIN')")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping(value = "/all",method = RequestMethod.GET,produces = {"application/json"})
    public List<Driver> getAll(){return driverService.getAllDriver();}

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = {"application/json"})
    public Driver getById(@PathVariable Long id) throws Exception{
        return driverService.getDriverById(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST,produces = {"application/json"})
    public Driver add(@RequestBody AddDriver addDriver) throws Exception{
        GeneralUtil.checkRequiredProperties(addDriver, Arrays.asList("firstName","LastName","carId"));
        return driverService.add(addDriver);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT,produces = {"application/json"})
    public Driver edit(@PathVariable Long id,@RequestBody AddDriver addDriver)throws Exception{
        GeneralUtil.checkRequiredProperties(addDriver,Arrays.asList("firstName","lastName","carId"));
        return driverService.edit(id,addDriver);
    }

}
