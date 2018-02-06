package CinemaTickets.tickets.models;

import java.util.ArrayList;
import java.util.List;

public class Booking {

	private List<Ticket> tickets;

	public Booking() {
		tickets = new ArrayList<>();
	}

	public float getPrice() {
		return getPrice(Day.MONDAY);
	}

	public float getPrice(Day day) {
		return tickets.stream().map(ticket -> ticket.getPrice(day)).reduce(0.f, (price1, price2) -> price1 + price2);
	}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

}
