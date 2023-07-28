package com.DriverPassenger.demo.entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @SequenceGenerator(name = "driver_id_seq",sequenceName ="driver_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="driver_id_seq")
    @Column(name = "driver_id")
    private Long driverId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "active")
    private Integer active;

    @Column(name = "create_date")
    private Date createDate;

    @JoinColumn(name = "car_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
