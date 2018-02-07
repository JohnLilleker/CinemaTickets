package CinemaTickets.tickets.models;

import java.util.HashMap;
import java.util.Map;

public class BookingSystem {

	private Map<Integer, Booking> bookings;
	private int nextID;

	public BookingSystem() {
		bookings = new HashMap<>();
		nextID = 0;
	}

	public int availableBookings() {
		return bookings.size();
	}

	public Booking getBooking(int id) {
		return bookings.get(id);
	}

	public void addBooking(Booking booking) {
		bookings.put((nextID++), booking);
	}

	public void cancelBooking(int id) {
		bookings.remove(id);
	}

}
