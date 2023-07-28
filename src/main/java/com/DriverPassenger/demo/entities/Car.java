package com.DriverPassenger.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "car_id")
    private Long carId;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "created_year")
    private Integer createdYear;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(Integer createdYear) {
        this.createdYear = createdYear;
    }
}
