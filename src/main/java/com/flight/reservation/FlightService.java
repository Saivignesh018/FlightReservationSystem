package com.flight.reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightService {
    private List<Flight> flights = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public FlightService() {
        // London Flights
        flights.add(new Flight("F101", "New York", "London", LocalDateTime.of(2025, 12, 9, 8, 30), 120));
        flights.add(new Flight("F102", "New York", "London", LocalDateTime.of(2025, 12, 9, 12, 45), 80));
        flights.add(new Flight("F103", "New York", "London", LocalDateTime.of(2025, 12, 9, 18, 0), 60));
        flights.add(new Flight("F104", "Boston", "London", LocalDateTime.of(2025, 12, 10, 9, 15), 100));
        flights.add(new Flight("F105", "Boston", "London", LocalDateTime.of(2025, 12, 10, 16, 45), 50));
        // Paris Flights
        flights.add(new Flight("F201", "New York", "Paris", LocalDateTime.of(2025, 12, 9, 9, 0), 100));
        flights.add(new Flight("F202", "Boston", "Paris", LocalDateTime.of(2025, 12, 10, 15, 30), 90));
        flights.add(new Flight("F203", "Boston", "Paris", LocalDateTime.of(2025, 12, 10, 20, 0), 50));
        flights.add(new Flight("F204", "Chicago", "Paris", LocalDateTime.of(2025, 12, 11, 10, 0), 80));
        flights.add(new Flight("F205", "Chicago", "Paris", LocalDateTime.of(2025, 12, 11, 18, 15), 60));
        // New York Flights
        flights.add(new Flight("F301", "London", "New York", LocalDateTime.of(2025, 12, 11, 7, 0), 200));
        flights.add(new Flight("F302", "Paris", "New York", LocalDateTime.of(2025, 12, 11, 13, 15), 150));
        flights.add(new Flight("F303", "Tokyo", "New York", LocalDateTime.of(2025, 12, 11, 22, 45), 100));
        flights.add(new Flight("F304", "Sydney", "New York", LocalDateTime.of(2025, 12, 12, 9, 0), 120));
        flights.add(new Flight("F305", "Dubai", "New York", LocalDateTime.of(2025, 12, 12, 17, 30), 80));
        // Tokyo Flights
        flights.add(new Flight("F401", "London", "Tokyo", LocalDateTime.of(2025, 12, 12, 6, 0), 180));
        flights.add(new Flight("F402", "Paris", "Tokyo", LocalDateTime.of(2025, 12, 12, 14, 30), 120));
        flights.add(new Flight("F403", "New York", "Tokyo", LocalDateTime.of(2025, 12, 12, 21, 0), 90));
        flights.add(new Flight("F404", "Sydney", "Tokyo", LocalDateTime.of(2025, 12, 13, 8, 0), 150));
        flights.add(new Flight("F405", "Dubai", "Tokyo", LocalDateTime.of(2025, 12, 13, 19, 30), 100));
        // Sydney Flights
        flights.add(new Flight("F501", "London", "Sydney", LocalDateTime.of(2025, 12, 13, 10, 0), 150));
        flights.add(new Flight("F502", "Paris", "Sydney", LocalDateTime.of(2025, 12, 13, 18, 30), 100));
        flights.add(new Flight("F503", "New York", "Sydney", LocalDateTime.of(2025, 12, 14, 9, 0), 120));
        flights.add(new Flight("F504", "Tokyo", "Sydney", LocalDateTime.of(2025, 12, 14, 20, 15), 80));
        // Dubai Flights
        flights.add(new Flight("F601", "London", "Dubai", LocalDateTime.of(2025, 12, 14, 7, 0), 150));
        flights.add(new Flight("F602", "Paris", "Dubai", LocalDateTime.of(2025, 12, 14, 13, 30), 120));
        flights.add(new Flight("F603", "New York", "Dubai", LocalDateTime.of(2025, 12, 15, 21, 0), 100));
        // Singapore Flights
        flights.add(new Flight("F701", "London", "Singapore", LocalDateTime.of(2025, 12, 15, 9, 0), 180));
        flights.add(new Flight("F702", "Paris", "Singapore", LocalDateTime.of(2025, 12, 15, 15, 45), 140));
        flights.add(new Flight("F703", "New York", "Singapore", LocalDateTime.of(2025, 12, 16, 22, 0), 90));
    }

    public void addFlight(Flight flight) { flights.add(flight); }

    public List<Flight> searchFlights(String source, String destination, LocalDateTime date) {
        List<Flight> result = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getSource().equalsIgnoreCase(source)
                    && f.getDestination().equalsIgnoreCase(destination)
                    && f.getDepartureTime().toLocalDate().equals(date.toLocalDate())) {
                result.add(f);
            }
        }
        return result;
    }

    public Flight getFlightByNumber(String flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber))
                .findFirst()
                .orElse(null);
    }

    public Reservation bookFlight(String customerName, Flight flight, int seats) {
        if (flight.bookSeats(seats)) {
            Reservation r = new Reservation(customerName, flight, seats);
            reservations.add(r);
            return r;
        } else return null;
    }

    public List<Reservation> getReservations() { return reservations; }
}
