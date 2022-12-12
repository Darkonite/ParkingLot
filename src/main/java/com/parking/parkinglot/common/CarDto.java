package com.parking.parkinglot.common;

public class CarDto {
    private long Id;
    String licensePlate;
    String parkingSpot;
    String ownerName;

    public CarDto(long id, String licensePlate, String parkingSpot, String ownerName) {
        Id = id;
        this.licensePlate = licensePlate;
        this.parkingSpot = parkingSpot;
        this.ownerName = ownerName;
    }

    public CarDto() {
    }

    public long getId() {
        return Id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public String getOwnerName() {
        return ownerName;
    }
}
