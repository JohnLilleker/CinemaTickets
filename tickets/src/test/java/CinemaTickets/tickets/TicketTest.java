package CinemaTickets.tickets;

import static org.junit.Assert.*;

import org.junit.Test;

import CinemaTickets.tickets.models.*;

public class TicketTest {

	@Test
	public void testTicketPrices() {
		Ticket standard = new StandardTicket();
		assertEquals(8.f, standard.getPrice(), 0.001);

		Ticket oap = new OAPTicket();
		assertEquals(6.f, oap.getPrice(), 0.001);

		Ticket student = new StudentTicket();
		assertEquals(6.f, student.getPrice(), 0.001);

		Ticket child = new ChildTicket();
		assertEquals(4.f, child.getPrice(), 0.001);

	}

}
