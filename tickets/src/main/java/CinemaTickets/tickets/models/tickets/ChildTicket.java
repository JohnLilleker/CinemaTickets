package CinemaTickets.tickets.models.tickets;

public class ChildTicket extends Ticket {

	public ChildTicket() {
		super(4.f);
	}

	public String toString() {
		return "Child ticket : " + super.toString();
	}

}
