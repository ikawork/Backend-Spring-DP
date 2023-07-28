package com.DriverPassenger.demo.entities.enums;

public enum Permission {
    DRIVER_READ("driver:read"),DRIVER_ADD("driver:add"),PASSENGER_READ("passenger:read"),PASSENGER_ADD("passenger:add");

    Permission(String permission) {
        this.permission = permission;
    }

    private String permission;

    public String getPermission() {
        return permission;
    }
}
