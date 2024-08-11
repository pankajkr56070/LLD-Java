package TicketBookingSystem.models;

import java.util.List;

public class Screen {
    private String screenId;
    private String screenName;
    private int capacity;
    private List<Showtime> showtimes;
    public Screen(String screenId, String screenName, int capacity, List<Showtime> showtimes) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.capacity = capacity;
        this.showtimes = showtimes;
    }

}
