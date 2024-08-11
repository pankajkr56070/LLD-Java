package TicketBookingSystem.services;

import java.util.List;

import TicketBookingSystem.models.*;

public class BookingService {

    public Booking createBooking(User user, Showtime showtime, List<String> seatNumbers) {
        return new Booking();
    }

    public void cancelBooking(String bookingId) {
        // Implementation for canceling a booking
    }

}
