package com.DriverPassenger.demo.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @SequenceGenerator(name = "passenger_id_seq",sequenceName = "passenger_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="passenger_id_seq")
    @Column(name = "passenger_id")
    private Long passengerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "active")
    private Integer active;

    @Column(name = "create_date")
    private Date createDate;

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
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
