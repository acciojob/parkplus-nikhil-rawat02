package com.driver;

import com.driver.DTO.PaymentResponseDto;
import com.driver.DTO.ReservationResponseDto;
import com.driver.DTO.SpotResponseDto;
import com.driver.model.Payment;
import com.driver.model.Reservation;
import com.driver.model.Spot;
import com.driver.model.SpotType;

public class Converter {

    public static SpotResponseDto spotToSpotResponseDto(Spot spot){
        return new SpotResponseDto(spot.getId(), spot.getSpotType(),spot.getPricePerHour(),spot.isOccupied(),spot.getParkingLot().getName());
    }

    public static ReservationResponseDto reservationToReservationResponseDto(Reservation reservation){
        return new ReservationResponseDto(reservation.getId(),reservation.getNumberOfHours(),reservation.getUser().getId(),reservation.getSpot().getId());
    }

    public static PaymentResponseDto paymentToPaymentResponseDto(Payment payment){
        return new PaymentResponseDto(payment.getId(),payment.isPaymentCompleted(),payment.getPaymentMode(),payment.getReservation().getId());
    }
}
