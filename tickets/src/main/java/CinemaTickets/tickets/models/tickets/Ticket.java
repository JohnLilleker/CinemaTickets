package CinemaTickets.tickets.models.tickets;

import CinemaTickets.tickets.models.Day;

public abstract class Ticket {
	private float price;

	public Ticket(float price) {
		this.price = price;
	}

	public float getPrice() {
		return getPrice(Day.MONDAY);
	}

	public float getPrice(Day day) {
		return (day == Day.WEDNESDAY) ? price - 2 : price;
	}

	public String toString() {
		return String.format("£%.2f", getPrice());
	}
}
