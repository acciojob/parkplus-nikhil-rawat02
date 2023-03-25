package com.driver.DTO;

import com.driver.model.ParkingLot;
import com.driver.model.Reservation;
import com.driver.model.SpotType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class SpotResponseDto {

    private int id;

    private SpotType spotType;

    private int pricePerHour;

    private boolean occupied;

    private String parkingLot;

    public SpotResponseDto() {
    }

    public SpotResponseDto(int id, SpotType spotType, int pricePerHour, boolean occupied, String parkingLot) {
        this.id = id;
        this.spotType = spotType;
        this.pricePerHour = pricePerHour;
        this.occupied = occupied;
        this.parkingLot = parkingLot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(String parkingLot) {
        this.parkingLot = parkingLot;
    }
}
