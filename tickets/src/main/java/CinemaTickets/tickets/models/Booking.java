package CinemaTickets.tickets.models;

import java.util.ArrayList;
import java.util.List;

import CinemaTickets.tickets.models.tickets.Ticket;

public class Booking {

	private List<Ticket> tickets;
	private Day dayOfFilm;

	public Booking(Day dayOfFilm) {
		tickets = new ArrayList<>();
		this.dayOfFilm = dayOfFilm;
	}

	public float getPrice() {
		return (float) tickets.stream().mapToDouble(ticket -> ticket.getPrice(dayOfFilm)).sum();
	}

	public Day getDay() {
		return dayOfFilm;
	}

	public void setDay(Day dayOfFilm) {
		this.dayOfFilm = dayOfFilm;
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

	@Override
	public String toString() {
		return "Booking on " + dayOfFilm.toString() + ": " + tickets.toString() + " Total = "
				+ String.format("%.2f", getPrice());
	}

}
