package com.flight.reservation;

import java.util.Random;

public class Reservation {
    private String reservationId;
    private String customerName;
    private Flight flight;
    private int seatsBooked;

    public Reservation(String customerName, Flight flight, int seatsBooked) {
        this.customerName = customerName;
        this.flight = flight;
        this.seatsBooked = seatsBooked;
        this.reservationId = generateReservationId();
    }

    private String generateReservationId() {
        Random random = new Random();
        return String.valueOf(10000 + random.nextInt(90000));
    }

    public String getReservationId() { return reservationId; }
    public String getCustomerName() { return customerName; }
    public Flight getFlight() { return flight; }
    public int getSeatsBooked() { return seatsBooked; }

    @Override
    public String toString() {
        return String.format("%-7s | %-10s | %-8s | %-12s | %-16s | %-5d",
                reservationId,
                customerName,
                flight.getFlightNumber(),
                flight.getSource(),
                flight.getDestination() + " " + flight.getDepartureTime(),
                seatsBooked);
    }
}
