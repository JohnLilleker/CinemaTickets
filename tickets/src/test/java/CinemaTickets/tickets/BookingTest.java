package CinemaTickets.tickets;

import static org.junit.Assert.*;

import org.junit.Test;

import CinemaTickets.tickets.models.*;

public class BookingTest {

	@Test
	public void testEmptyBooking() {
		Booking booking = new Booking();
		assertEquals(0, booking.getPrice(), 0.001f);
	}

	@Test
	public void testStandardBooking() {
		Booking booking = new Booking();
		booking.addTicket(new StandardTicket());
		booking.addTicket(new StudentTicket());
		booking.addTicket(new ChildTicket());
		assertEquals(18.f, booking.getPrice(), 0.001f);
	}

	@Test
	public void testWednesdayBooking() {
		Booking booking = new Booking();
		booking.addTicket(new StandardTicket());
		booking.addTicket(new StudentTicket());
		booking.addTicket(new ChildTicket());
		assertEquals(12, booking.getPrice(Day.WEDNESDAY), 0.001f);
	}
}
