package CinemaTickets.tickets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import CinemaTickets.tickets.models.Booking;
import CinemaTickets.tickets.models.BookingSystem;
import CinemaTickets.tickets.models.tickets.StandardTicket;

public class BookingSystemTests {

	BookingSystem system;
	
	@Before
	public void setup() {
		system = new BookingSystem();
	}
	
	@Test
	public void testEmptySystem() {
		assertEquals(0, system.availableBookings());
		assertNull(system.getBooking(0));
		fail("Not yet implemented");
	}
	
	@Test
	public void testSystemWithABooking() {
		Booking booking = new Booking();
		booking.addTicket(new StandardTicket());
		system.addBooking(booking);
		assertEquals(1, system.availableBookings());
		assertEquals(booking, system.getBooking(0));
		assertNull(system.getBooking(1));
	}
}
