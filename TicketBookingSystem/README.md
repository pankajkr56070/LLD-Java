REQUIREMENTS :

a) User should be able to book movie tickets 
b) User can pay the amount through various ways - debit/credit/UPI
c) User can select multiple seats 
d) No two users should be able to book the same seat
e) Once booking is confirmed, user should get the email notification and SMS notified regrading the booking details
f) A confirmed booking can be cancelled before some time of the event - if it is cancelled before a given time period,  money should be refunded else there would be no refund
g) User should be able to search the movies


Entities : 
a) User - id, name, email,  phone
b) EventBooking - id, userId, bookingStatus, amount, modeOfPayment, date
c) BookingStatus - PENDING/CONFIRMED/CANCELLED
g) PaymentMode - CREDTI/DEBIT/UPI
h) Payment - transactionId, amount, date, paymentMode : 
i) Notification interface - send(User user, String message) : PushNotification/SMS



1.	User Management
	•	Users
	•	Authentication
2.	Movie Management
	•	Movies
	•	Showtimes
	•	Theaters
3.	Booking Management
	•	Bookings
	•	Payments
	•	Tickets
4.	Notification Management
	•	Notifications
	•	Observers
5.	Search and Filter
	•	SearchService
	•	FilterService
6.	Integration
	•	API Gateway
7.	Storage
	•	Database for persistent storage
	•	Cache for performance optimization