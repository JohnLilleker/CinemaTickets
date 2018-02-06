package CinemaTickets.tickets.models;

public abstract class Ticket {
	protected float price;

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
