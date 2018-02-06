package CinemaTickets.tickets;

import static org.junit.Assert.*;

import org.junit.Test;

import CinemaTickets.tickets.models.*;
import CinemaTickets.tickets.models.tickets.*;

public class TicketTest {

	final float PRECISION = 0.001f;

	@Test
	public void testTicketPrices() {
		Ticket standard = new StandardTicket();
		assertEquals(8.f, standard.getPrice(), PRECISION);

		Ticket oap = new OAPTicket();
		assertEquals(6.f, oap.getPrice(), PRECISION);

		Ticket student = new StudentTicket();
		assertEquals(6.f, student.getPrice(), PRECISION);

		Ticket child = new ChildTicket();
		assertEquals(4.f, child.getPrice(), PRECISION);
	}

	@Test
	public void testTicketPricesOnWednesday() {
		Ticket stnd = new StandardTicket();
		assertEquals(6.f, stnd.getPrice(Day.WEDNESDAY), PRECISION);

		Ticket oap = new OAPTicket();
		assertEquals(4.f, oap.getPrice(Day.WEDNESDAY), PRECISION);

		Ticket student = new StudentTicket();
		assertEquals(4.f, student.getPrice(Day.WEDNESDAY), PRECISION);

		Ticket child = new ChildTicket();
		assertEquals(2.f, child.getPrice(Day.WEDNESDAY), PRECISION);
	}

	@Test
	public void testTicketsOnOtherDays() {
		for (Day day : Day.values()) {
			if (day != Day.WEDNESDAY) {
				Ticket standard = new StandardTicket();
				assertEquals(8.f, standard.getPrice(day), PRECISION);

				Ticket oap = new OAPTicket();
				assertEquals(6.f, oap.getPrice(day), PRECISION);

				Ticket student = new StudentTicket();
				assertEquals(6.f, student.getPrice(day), PRECISION);

				Ticket child = new ChildTicket();
				assertEquals(4.f, child.getPrice(day), PRECISION);
			}
		}

	}

}
