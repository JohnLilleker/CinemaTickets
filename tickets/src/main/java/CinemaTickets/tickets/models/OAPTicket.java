package CinemaTickets.tickets.models;

public class OAPTicket extends Ticket {

	public OAPTicket() {
		super(6.f);
	}

	public String toString() {
		return "Concessionary ticket : " + super.toString();
	}
}
