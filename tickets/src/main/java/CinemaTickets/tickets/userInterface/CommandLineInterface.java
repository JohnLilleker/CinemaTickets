package CinemaTickets.tickets.userInterface;

import java.util.Scanner;

import CinemaTickets.tickets.models.*;

public class CommandLineInterface {

	private Scanner reader;
	private BookingSystem system;

	/*
	 * Layers
	 * 
	 * menu
	 * 
	 * - view all bookings
	 * 
	 * - add new booking
	 * 
	 * - cancel bookings
	 * 
	 * - interact with bookings
	 * 
	 */

	public CommandLineInterface() {
		reader = new Scanner(System.in);
		system = new BookingSystem();
	}

	// methods

	// select a booking
	// add tickets to a booking
	// remove tickets from booking
	// cancel a booking

	public void startInterface() {
		out("Ticket Booking System");
		Command command = null;
		do {
			menu();
			command = getCommand();
		} while (doCommand(command));
		out("Good bye");
	}

	private boolean doCommand(Command command) {
		switch (command) {
		case ADD_BOOKING:
			createBooking();
			break;
		case CANCEL_BOOKING:
			cancelBooking();
			break;
		case VIEW_BOOKING:
			break;
		case QUIT:
			if (areYouSure()) {
				return false;
			}
		case SHOW_ALL:
			displayBookings();
			break;
		default:
			out("Unkown Command");
			break;
		}
		return true;
	}

	private void menu() {
		out("Menu");
		out(" 0 - Show all active bookings");
		out(" 1 - Add a new booking");
		out(" 2 - View and edit a booking");
		out(" 3 - Cancel a booking");
		out(" 4 - exit this tool");
	}

	private void displayBookings() {
		out("ID   | Booking");
		out("-----|-------------------------------------");
		for (int i = 0; i < system.availableBookings(); i++) {
			Booking booking = system.getBooking(i);
			if (booking != null) {
				out(String.format("%-5d", i) + "| " + booking.toString());
			}
		}
	}

	private void createBooking() {
		boolean correctInput = false;
		do {
			String input = in("What day do you want to book the tickets for? ").toUpperCase();
			if (input.equals("CANCEL")) {
				out("Booking cancelled");
				break;
			}
			try {
				Day day = Day.valueOf(input);
				system.addBooking(new Booking(day));
				correctInput = true;
				out("booking added");
			} catch (Exception e) {
				out("Invalid day");
			}
		} while (!correctInput);
	}

	private void cancelBooking() {
		out("Cancel a booking");
		out("Which one should be cancelled?");
		displayBookings();

		String input = in("Enter the id ");
		try {
			int id = Integer.valueOf(input);
			Booking toCancel = system.getBooking(id);
			if (toCancel != null) {
				out(toCancel.toString());
				if (areYouSure()) {
					system.cancelBooking(id);
					out("Booking cancelled");
				}
			}
		} catch (Exception e) {

		}

	}

	private Command getCommand() {
		boolean correctInput = false;
		Command command = null;

		do {
			String input = in("Enter a command > ");
			if (input.matches("^\\d$")) {
				int choiceOfCommand = Integer.parseInt(input);
				if (choiceOfCommand >= 0 && choiceOfCommand < Command.values().length) {
					command = Command.values()[choiceOfCommand];
					correctInput = true;
				} else {
					out("Invalid input, please try again");
				}
			} else {
				out("Invalid input, please try again");
			}

		} while (!correctInput);

		return command;
	}

	private boolean areYouSure() {
		System.out.println("Are you sure? ");
		String input = reader.nextLine().toLowerCase();
		return input.charAt(0) == 'y';
	}

	private String in(String prompt) {
		System.out.print(prompt);
		return reader.nextLine();
	}

	private void out(String output) {
		System.out.println(output);
	}
}
