package CinemaTickets.tickets.models;

public class StandardTicket extends Ticket {

	public StandardTicket() {
		super(8.f);
	}

	public String toString() {
		return "Standard ticket : " + super.toString();
	}
}
