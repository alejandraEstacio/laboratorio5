package model;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Airport {
	
	private Flight first;
	private Flight last;
	private ArrayList<Flight> flights;
	
	
	public Airport() {
		first = null;
		last = null;
		flights = new ArrayList<Flight>();	
	}
	
	
	public void addEnd(Flight f) {
		
		Flight u = latest();
		if(u == null) 
			first = f;
		else {
			u.setSiguiente(f);
			f.setAnterior(u);
			
		}
			
	}
	public Flight latest() {
		
		Flight act= first;
		Flight ant = null;
		while(act !=null) {
			ant = act;
			act = act.getSiguiente();

		}
	return act;
	}

// ordenar insercion
	
	public void orderNumberFlight() {
		Flight actual = first.getSiguiente();
		Flight siguiente = actual.getSiguiente();
		
		boolean cambio = false;
		while(actual!=null) {
			cambio = true;
			while(cambio == true && actual.getAnterior()!=null) {
				cambio = false;
				if(actual.getAnterior().getFlightNumber() > actual.getFlightNumber()) {
					actual = exchange(actual.getAnterior(), actual);
				cambio = true;
				}
			}
			actual = siguiente;
			if(actual != null) {
				siguiente = actual.getSiguiente();
			}	
		}
		
	}
	
	public void orderDestination() {
		Flight actual = first.getSiguiente();
		Flight siguiente = actual.getSiguiente();
		
		boolean cambio = false;
		while(actual!=null) {
			cambio = true;
			while(cambio == true && actual.getAnterior()!=null) {
				cambio = false;
				if(actual.getAnterior().getDestination().compareToIgnoreCase(actual.getDestination()) > 0) {
					actual = exchange(actual.getAnterior(), actual);
				cambio = true;
				}
			}
			actual = siguiente;
			if(actual != null) {
				siguiente = actual.getSiguiente();
			}	
		}
		
	}
	
	 public Flight exchange(Flight p, Flight q){
	        Flight s = null;
	        Flight r = null;
	        if(p.getSiguiente() != q){
	            s = p.getSiguiente();
	            r = q.getAnterior();
	        }
	        p.setSiguiente(q.getSiguiente());
	        q.setAnterior(p.getAnterior());
	        if(q.getSiguiente() != null){
	            q.getSiguiente().setAnterior(p);
	        }
	        if(p.getAnterior() != null){
	            p.getAnterior().setSiguiente(q);
	        }else{
	            first = q;
	        }
	        if(s != null && r != null){
	            r.setSiguiente(p);
	            s.setAnterior(q);
	            q.setSiguiente(s);
	            p.setAnterior(r);
	        }else{
	            q.setSiguiente(p);
	            p.setAnterior(q);
	        }
	        return q;
	    }
	
	
//ordenar por burbuja
	
	public void orderDateTime() {
	
	boolean cambio;
	
	do {
		Flight actual = first;
		Flight anterior = null;
		Flight siguiente = first.getSiguiente();
		
		cambio = false;
		while(siguiente != null) {
			if(actual.getDate().compareTo(siguiente.getDate())>0) {

				cambio = true;
				if(anterior !=null) {
					Flight sig= siguiente.getSiguiente();
					anterior.setSiguiente(siguiente);
					siguiente.setSiguiente(actual);
					actual.setSiguiente(sig);
				}else {
					Flight sig = siguiente.getSiguiente();
					first = siguiente;
					siguiente.setSiguiente(actual);
					actual.setSiguiente(sig);
				}
				anterior = siguiente;
				siguiente = actual.getSiguiente();
			}else {
				anterior = actual;
				actual = siguiente;
				siguiente = siguiente.getSiguiente();
			}
		}
	}while(cambio);
	}
	
	
	public void orderAirline() {
		
		boolean cambio;
		
		do {
			Flight actual = first;
			Flight anterior = null;
			Flight siguiente = first.getSiguiente();
			
			cambio = false;
			while(siguiente != null) {
				if(actual.getAirline().compareTo(siguiente.getAirline())>0) {

					cambio = true;
					if(anterior !=null) {
						Flight sig= siguiente.getSiguiente();
						anterior.setSiguiente(siguiente);
						siguiente.setSiguiente(actual);
						actual.setSiguiente(sig);
					}else {
						Flight sig = siguiente.getSiguiente();
						first = siguiente;
						siguiente.setSiguiente(actual);
						actual.setSiguiente(sig);
					}
					anterior = siguiente;
					siguiente = actual.getSiguiente();
				}else {
					anterior = actual;
					actual = siguiente;
					siguiente = siguiente.getSiguiente();
				}	
			}
		}while(cambio);
		}
	
	
	public void orderBoardingGates() {
		
		boolean cambio;
		
		do {
			Flight actual = first;
			Flight anterior = null;
			Flight siguiente = first.getSiguiente();
			
			cambio = false;
			while(siguiente != null) {
				if(actual.getBoardingGate()>siguiente.getBoardingGate()) {

					cambio = true;
					if(anterior !=null) {
						Flight sig= siguiente.getSiguiente();
						anterior.setSiguiente(siguiente);
						siguiente.setSiguiente(actual);
						actual.setSiguiente(sig);
					}else {
						Flight sig = siguiente.getSiguiente();
						first = siguiente;
						siguiente.setSiguiente(actual);
						actual.setSiguiente(sig);
					}
					anterior = siguiente;
					siguiente = actual.getSiguiente();
				}else {
					anterior = actual;
					actual = siguiente;
					siguiente = siguiente.getSiguiente();
				}
			}
		}while(cambio);
		}
		
		
//Busqueda 
	public Flight searchByDateTime(String date) {
		
		Flight act = first;
	
		while(act != null && !act.getDate().equalsIgnoreCase(date)) {
					
			act = act.getSiguiente();
		}
		return act;
	}
	
	public Flight searchByDestination(String dest) {
		
		Flight act = first;
	
		while(act != null && !act.getDestination().equalsIgnoreCase(dest)) {
					
			act = act.getSiguiente();
			
		}
		return act;
	}
	
	public Flight searchByAirline(String air) {
		
		Flight act = first;
	
		while(act != null && !act.getAirline().equalsIgnoreCase(air)) {
					
			act = act.getSiguiente();
		}
		return act;
	}
	
	public Flight searchbyNumberFlight(int num) {
		
		Flight act = first;
	
		while(act != null && !(act.getFlightNumber()== num)) {
					
			act = act.getSiguiente();
		}
		return act;
	}
	
	public Flight searchbyBoardingGate(int boarding) {
		
		Flight act = first;
	
		while(act != null && !(act.getBoardingGate()== boarding)) {
					
			act = act.getSiguiente();
		}
		return act;
	}
	
	 public ArrayList<Flight> getFlights( ) {
		 
	        ArrayList<Flight> flights = new ArrayList<Flight>( );
	       Flight actual = first;
	        while( actual != null )
	        {
	            flights.add( actual );
	            actual = actual.getSiguiente( );
	        }
	        return flights;
	    }
	
	public  ObservableList<Flight> loadTxt() throws IOException{
		
		ObservableList<Flight> flights = FXCollections.observableArrayList();
		
		BufferedReader in = new BufferedReader(new FileReader("./data/data.txt"));
		String line = in.readLine();
		
		while(line != null) {
			
			String[] arr = line.split(",");
			String[] arr2 = arr[0].split("-");
			String[] arr3 = arr[2].split(" ");
			
			Flight f = new Flight(LocalDateTime.parse(arr[0], DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a")), arr[1],Integer.parseInt(arr[2]), arr[3],Integer.parseInt(arr[4]));
			flights.add(f);
			line = in.readLine();
		}
		in.close();
	return flights;
	}
}
