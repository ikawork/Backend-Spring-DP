package com.DriverPassenger.demo.services;

import com.DriverPassenger.demo.dto.AddPassenger;
import com.DriverPassenger.demo.entities.Passenger;
import com.DriverPassenger.demo.repositories.PassengerRepository;
import com.DriverPassenger.demo.utils.GeneralUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassenger(){ return passengerRepository.findAll();}


    public Passenger getPassengerById(Long id) throws Exception{

        return passengerRepository.findById(id).orElseThrow(()->new Exception("RECORD_NOT_FOUND"));
    }

    @Transactional
    public Passenger add(AddPassenger addPassenger) throws Exception {
        Passenger passenger = new Passenger();
        passenger.setCreateDate(new Date());
        GeneralUtil.getCopyOf(addPassenger, passenger);

        return passengerRepository.save(passenger);
    }

    @Transactional
    public Passenger edit(Long id,AddPassenger addPassenger)throws Exception{
        Passenger passenger = getPassengerById(id);
        GeneralUtil.getCopyOf(addPassenger, passenger);
        return passengerRepository.save(passenger);


    }


}
