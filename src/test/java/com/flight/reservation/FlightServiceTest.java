package com.flight.reservation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

public class FlightServiceTest {

    @Test
    void testSearchFlights() {
        FlightService service = new FlightService();
        List<Flight> flights = service.searchFlights("New York", "London", LocalDateTime.of(2025,12,9,0,0));
        assertEquals(3, flights.size());
    }

    @Test
    void testBookFlightSuccess() {
        FlightService service = new FlightService();
        Flight f = service.getFlightByNumber("F101");
        Reservation r = service.bookFlight("Alice", f, 2);
        assertNotNull(r);
        assertEquals(118, f.getAvailableSeats());
    }

    @Test
    void testBookFlightFail() {
        FlightService service = new FlightService();
        Flight f = service.getFlightByNumber("F101");
        Reservation r = service.bookFlight("Bob", f, 500);
        assertNull(r);
    }

    @Test
    void testGetReservations() {
        FlightService service = new FlightService();
        Flight f = service.getFlightByNumber("F101");
        service.bookFlight("Alice", f, 2);
        List<Reservation> res = service.getReservations();
        assertEquals(1, res.size());
    }
}
