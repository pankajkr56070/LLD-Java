package TicketBookingSystem.models;

import java.time.LocalDateTime;

public class Showtime {
    private String showtimeId;
    private LocalDateTime startTime;
    private Movie movie;
    private Screen screen;
    public Showtime(String showtimeId, LocalDateTime startTime, Movie movie, Screen screen) {
        this.showtimeId = showtimeId;
        this.startTime = startTime;
        this.movie = movie;
        this.screen = screen;
    }

}
