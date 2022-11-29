package com.parking.parkinglot.common;

public class CarDto {
    private long Id;
    String licensePlate;
    String parkingSpot;
    String ownername;

    public CarDto(long id, String licensePlate, String parkingSpot, String ownername) {
        Id = id;
        this.licensePlate = licensePlate;
        this.parkingSpot = parkingSpot;
        this.ownername = ownername;
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

    public String getOwnername() {
        return ownername;
    }
}
