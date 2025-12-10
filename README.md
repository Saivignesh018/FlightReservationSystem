# Flight Reservation System

## Overview
A console-based Java application that simulates a real-world flight booking system. Users can search flights by source, destination, and date, book available flights, and view their reservations. Data is stored in-memory during runtime.

## Features
- Search flights by **source**, **destination**, and **date**.
- Book flights with **seat availability validation**.
- View all reservations with **unique reservation IDs**.
- Unit tests with JUnit 5 ensure the system works correctly.
- Random reservation IDs simulate real airline booking codes.

## Technologies
- Java 21
- Maven 3.9.11
- JUnit 5
- In-memory data structures (ArrayList)

## Design Decisions
- **In-memory storage:** Chosen for simplicity; easy to expand to database later.
- **Random reservation IDs:** Realistic unique codes for each booking.
- **Flight and Reservation classes:** Clear separation of data and responsibilities.
- **FlightService class:** Handles all business logic; main console class handles user interaction.
- **Unit tests:** Cover booking, searching, and edge cases like overbooking.

## Real-Life Considerations
- Overbooking prevention ensures flight seat limits are respected.
- Unique reservation IDs reflect real-world airline booking behavior.
- Console interface is simple but can be extended to GUI or web application.
- In-memory storage is temporary; production would require persistent storage.

## How to Run
1. Clone the repository:
```bash
git clone https://github.com/Saivignesh018/FlightReservationSystem.git
