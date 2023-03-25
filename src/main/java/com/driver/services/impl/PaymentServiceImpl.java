package com.driver.services.impl;

import com.driver.model.Payment;
import com.driver.model.PaymentMode;
import com.driver.model.Reservation;
import com.driver.model.Spot;
import com.driver.repository.PaymentRepository;
import com.driver.repository.ReservationRepository;
import com.driver.repository.SpotRepository;
import com.driver.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    ReservationRepository reservationRepository2;
    @Autowired
    PaymentRepository paymentRepository2;

    @Autowired
    SpotRepository spotRepository;

    @Override
    public Payment pay(Integer reservationId, int amountSent, String mode) throws Exception {
        //Attempt a payment of amountSent for reservationId using the given mode ("cASh", "card", or "upi")
        //If the amountSent is less than bill, throw "Insufficient Amount" exception, otherwise update payment attributes
        //If the mode contains a string other than "cash", "card", or "upi" (any character in uppercase or lowercase), throw "Payment mode not detected" exception.
        //Note that the reservationId always exists

        Reservation reservation = reservationRepository2.findById(reservationId).get();

        mode = mode.toUpperCase();
        PaymentMode paymentMode;
        if(PaymentMode.CARD.toString().equals(mode)){
            paymentMode = PaymentMode.CARD;
        } else if (PaymentMode.UPI.toString().equals(mode)) {
            paymentMode = PaymentMode.UPI;
        } else if (PaymentMode.CASH.toString().equals(mode)) {
            paymentMode = PaymentMode.CASH;
        } else {
            throw new Exception("Payment mode not detected");
        }

        int amount = reservation.getNumberOfHours() * reservation.getSpot().getPricePerHour();
        if(amount > amountSent){

            throw new Exception("Insufficient Amount");
        }

        Payment payment = new Payment();
        payment.setReservation(reservation);
        payment.setPaymentMode(paymentMode);
        payment.setPaymentCompleted(true);

        reservation.setPayment(payment);
        paymentRepository2.save(payment);
        return payment;
    }
}
