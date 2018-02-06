package CinemaTickets.tickets.models;

public abstract class Ticket {
	protected float price;

	public Ticket(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}
}
