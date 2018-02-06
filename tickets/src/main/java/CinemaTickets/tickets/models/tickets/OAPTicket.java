package CinemaTickets.tickets.models.tickets;

public class OAPTicket extends Ticket {

	public OAPTicket() {
		super(6.f);
	}

	public String toString() {
		return "Concessionary ticket : " + super.toString();
	}
}
