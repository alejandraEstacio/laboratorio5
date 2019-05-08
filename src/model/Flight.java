package model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flight implements Comparable<Flight>{

	private LocalDateTime date;
	private String airline;
	private int flightNumber;
	private String destination;
	private int boardingGate;
	
	private Flight siguiente;
	private Flight anterior;
	
	public Flight(LocalDateTime date, String airline, int flightNumber, String destination,
			int boardingGate) {
		
		this.date = date;
		this.airline = airline;
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.boardingGate = boardingGate;
	}

	public String getDate() {
		return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a"));
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getBoardingGate() {
		return boardingGate;
	}

	public void setBoardingGate(int boardingGate) {
		this.boardingGate = boardingGate;
	}

	public Flight getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Flight siguiente) {
		this.siguiente = siguiente;
	}

	public Flight getAnterior() {
		return anterior;
	}

	public void setAnterior(Flight anterior) {
		this.anterior = anterior;
	}
	
	@Override
	public int compareTo(Flight arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
