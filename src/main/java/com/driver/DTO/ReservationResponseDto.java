package com.driver.DTO;

import com.driver.model.Spot;
import com.driver.model.User;

import javax.persistence.*;

public class ReservationResponseDto {

   private int id;

    private int numberOfHours;

    private int userId;

    private int spotId;

    public ReservationResponseDto() {
    }

    public ReservationResponseDto(int id, int numberOfHours, int userId, int spotId) {
        this.id = id;
        this.numberOfHours = numberOfHours;
        this.userId = userId;
        this.spotId = spotId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }
}
