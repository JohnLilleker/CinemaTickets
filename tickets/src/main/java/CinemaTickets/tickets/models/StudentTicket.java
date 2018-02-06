package CinemaTickets.tickets.models;

public class StudentTicket extends Ticket {

	public StudentTicket() {
		super(6.f);
	}

	public String toString() {
		return "Student ticket : " + super.toString();
	}

}
