package TicketBookingSystem.models;

import java.util.List;

public class Booking {
    private String bookingId;
    private User user;
    private Showtime showtime;
    private List<Ticket> tickets;
    private Payment payment;
    public Payment getPayment() {
        return payment;
    }

}
