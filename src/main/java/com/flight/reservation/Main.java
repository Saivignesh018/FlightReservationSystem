package com.flight.reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightService service = new FlightService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Welcome to the Flight Reservation System ===");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View All Reservations");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Enter a valid number (1-4).");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Source: ");
                    String source = scanner.nextLine();
                    System.out.print("Enter Destination: ");
                    String dest = scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String dateStr = scanner.nextLine();

                    LocalDateTime date;
                    try {
                        date = LocalDate.parse(dateStr).atStartOfDay();
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Use YYYY-MM-DD.");
                        break;
                    }

                    List<Flight> results = service.searchFlights(source, dest, date);
                    if (results.isEmpty()) {
                        System.out.println("No flights found.");
                    } else {
                        System.out.println("\nAvailable Flights:");
                        System.out.printf("%-10s | %-10s | %-12s | %-20s | %-5s%n",
                                "Flight No", "Source", "Destination", "Departure Time", "Seats");
                        System.out.println("---------------------------------------------------------------");
                        for (Flight f : results) {
                            System.out.printf("%-10s | %-10s | %-12s | %-20s | %-5d%n",
                                    f.getFlightNumber(), f.getSource(), f.getDestination(),
                                    f.getDepartureTime(), f.getAvailableSeats());
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Flight Number: ");
                    String flightNum = scanner.nextLine();
                    System.out.print("Enter Seats to Book: ");
                    int seats = Integer.parseInt(scanner.nextLine());

                    Flight flight = service.getFlightByNumber(flightNum);
                    if (flight == null) {
                        System.out.println("Flight not found.");
                    } else {
                        Reservation r = service.bookFlight(name, flight, seats);
                        if (r != null) {
                            System.out.println("\n=== Booking Confirmation ===");
                            System.out.println("Reservation ID : " + r.getReservationId());
                            System.out.println("Customer Name  : " + r.getCustomerName());
                            System.out.println("Flight Number  : " + r.getFlight().getFlightNumber());
                            System.out.println("Source         : " + r.getFlight().getSource());
                            System.out.println("Destination    : " + r.getFlight().getDestination());
                            System.out.println("Date & Time    : " + r.getFlight().getDepartureTime());
                            System.out.println("Seats Booked   : " + r.getSeatsBooked());
                            System.out.println("Remaining Seats: " + r.getFlight().getAvailableSeats());
                        } else {
                            System.out.println("Not enough seats available.");
                        }
                    }
                    break;

                case 3:
                    List<Reservation> reservations = service.getReservations();
                    if (reservations.isEmpty()) {
                        System.out.println("No reservations yet.");
                    } else {
                        System.out.println("\nAll Reservations:");
                        System.out.printf("%-7s | %-10s | %-8s | %-12s | %-16s | %-5s%n",
                                "ResID", "Customer", "Flight", "Source", "Destination & Time", "Seats");
                        System.out.println("---------------------------------------------------------------");
                        for (Reservation r : reservations) {
                            System.out.println(r);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Enter 1-4.");
            }
        }
    }
}
