package TicketBookingSystem.models;

import java.time.LocalDateTime;

public class Payment {

    private String paymentId;
    private double amount;
    public double getAmount() {
        return amount;
    }
    private String paymentMethod;
    private LocalDateTime paymentDate;

}
