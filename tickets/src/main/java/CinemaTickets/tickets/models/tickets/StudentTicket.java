package CinemaTickets.tickets.models.tickets;

public class StudentTicket extends Ticket {

	public StudentTicket() {
		super(6.f);
	}

	public String toString() {
		return "Student ticket : " + super.toString();
	}

}
