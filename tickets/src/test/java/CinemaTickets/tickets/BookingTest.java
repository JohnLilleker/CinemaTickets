package CinemaTickets.tickets;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import CinemaTickets.tickets.models.*;
import CinemaTickets.tickets.models.tickets.*;

public class BookingTest {

	@Test
	public void testEmptyBooking() {
		Booking booking = new Booking(Day.MONDAY);
		assertEquals(0, booking.getPrice(), 0.001f);
	}

	@Test
	public void testStandardBooking() {
		Booking booking = new Booking(Day.MONDAY);
		List<Ticket> tickets = Arrays.asList(new StandardTicket(), new StudentTicket(), new ChildTicket());
		tickets.forEach(ticket -> booking.addTicket(ticket));
		assertEquals(tickets, booking.getTickets());
		assertEquals(18.f, booking.getPrice(), 0.001f);
	}

	@Test
	public void changeDayOfBooking() {
		Booking booking = new Booking(Day.MONDAY);
		assertEquals(Day.MONDAY, booking.getDay());
		booking.addTicket(new StandardTicket());
		assertEquals(8.f, booking.getPrice(), 0.001);
		booking.setDay(Day.WEDNESDAY);
		assertEquals(Day.WEDNESDAY, booking.getDay());
		assertEquals(6.f, booking.getPrice(), 0.001);
	}

	@Test
	public void testWednesdayBooking() {
		Booking booking = new Booking(Day.WEDNESDAY);
		booking.addTicket(new StandardTicket());
		booking.addTicket(new StudentTicket());
		booking.addTicket(new ChildTicket());
		assertEquals(12.f, booking.getPrice(), 0.001f);
	}

	@Test
	public void testThursdayBooking() {
		Booking booking = new Booking(Day.THURSDAY);
		booking.addTicket(new StandardTicket());
		booking.addTicket(new StudentTicket());
		booking.addTicket(new ChildTicket());
		assertEquals(18.f, booking.getPrice(), 0.001f);
	}

	@Test
	public void testRemoveTicket() {
		Booking booking = new Booking(Day.MONDAY);
		List<Ticket> before = Arrays.asList(new StandardTicket(), new StudentTicket(), new ChildTicket());
		before.forEach(ticket -> booking.addTicket(ticket));
		assertEquals(before, booking.getTickets());
		booking.removeTicket(before.get(0));
		assertNotEquals(before, booking.getTickets());
	}

}
