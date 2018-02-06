package CinemaTickets.tickets;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import CinemaTickets.tickets.models.*;
import CinemaTickets.tickets.models.tickets.*;

public class BookingTest {

	Booking booking;
	
	@Before
	public void setup() {

		booking = new Booking();
	}
	
	@Test
	public void testEmptyBooking() {
		assertEquals(0, booking.getPrice(), 0.001f);
	}

	@Test
	public void testStandardBooking() {
		List<Ticket> tickets = Arrays.asList(new StandardTicket(), new StudentTicket(), new ChildTicket());
		tickets.forEach(ticket -> booking.addTicket(ticket));
		assertEquals(tickets, booking.getTickets());
		assertEquals(18.f, booking.getPrice(), 0.001f);
	}

	@Test
	public void testWednesdayBooking() {
		booking.addTicket(new StandardTicket());
		booking.addTicket(new StudentTicket());
		booking.addTicket(new ChildTicket());
		assertEquals(12.f, booking.getPrice(Day.WEDNESDAY), 0.001f);
	}

	@Test
	public void testThursdayBooking() {
		booking.addTicket(new StandardTicket());
		booking.addTicket(new StudentTicket());
		booking.addTicket(new ChildTicket());
		assertEquals(18.f, booking.getPrice(Day.THURSDAY), 0.001f);
	}
	
	@Test
	public void testRemoveTicket() {
		List<Ticket> before = Arrays.asList(new StandardTicket(), new StudentTicket(), new ChildTicket());
		before.forEach(ticket -> booking.addTicket(ticket));
		assertEquals(before, booking.getTickets());
		booking.removeTicket(before.get(0));
		assertNotEquals(before, booking.getTickets());
	}
}
