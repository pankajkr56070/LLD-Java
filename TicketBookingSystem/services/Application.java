package TicketBookingSystem.services;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import TicketBookingSystem.models.*;

public class Application {

    public static void main(String[] args) {

        User user1 = new User("1", "abc@xyz.com", "123456789");
        User user2 = new User("2", "13456", "9876654431");

        Movie movie = new Movie("124", "Godfather", MovieGenre.CRIME,
                Duration.ofHours(2), "IMDB Top1 rated ", LocalDate.of(1974, 7, 16));


        Screen screen = new Screen("1", "AUDI", 200, new ArrayList<>());


        Showtime showtime = new Showtime("1" , LocalDateTime.now().plusDays(1), movie, screen);


        BookingService bookingService = new BookingService();
        List<String> seatNumbers = Arrays.asList("A1", "A2");
        Booking booking = bookingService.createBooking(user1, showtime, seatNumbers);


         // Payment Service
         PaymentService paymentService = new PaymentService();
         paymentService.setPaymentStrategy(new CreditCardPayment());
         paymentService.processPayment(booking.getPayment().getAmount());




    }

}
