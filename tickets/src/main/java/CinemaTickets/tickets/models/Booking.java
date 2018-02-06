package CinemaTickets.tickets.models;

import java.util.ArrayList;
import java.util.List;

import CinemaTickets.tickets.models.tickets.Ticket;

public class Booking {

	private List<Ticket> tickets;

	public Booking() {
		tickets = new ArrayList<>();
	}

	public float getPrice() {
		return getPrice(Day.MONDAY);
	}

	public float getPrice(Day day) {
		return (float) tickets.stream().mapToDouble(ticket -> ticket.getPrice(day)).sum();
	}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void removeTicket(Ticket ticket) {
		tickets.remove(ticket);
	}
	
}
