package com.flight.reservation;

import java.time.LocalDateTime;

public class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private LocalDateTime departureTime;
    private int availableSeats;

    public Flight(String flightNumber, String source, String destination, LocalDateTime departureTime, int availableSeats) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public int getAvailableSeats() { return availableSeats; }

    public boolean bookSeats(int seats) {
        if(seats <= 0 || seats > availableSeats) return false;
        availableSeats -= seats;
        return true;
    }
}
