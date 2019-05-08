package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Airport;
import model.Flight;

public class Controller implements Initializable {
	
	private Airport air;
	
		@FXML
	    private Pagination pagination;

	  	@FXML
		private TableColumn fechas, aerolineas, num, destinos, puertas ;
	    @FXML
	    private ListView<Flight> list;
	    
	    @FXML
	    private TextArea txtArea;
	    
	    @FXML
	    private TextField txt;
	    
	    
	    @FXML
	    void orderAirline(ActionEvent event) throws IOException {
	    	
	    	air.orderAirline();
	    }

	    @FXML
	    void orderBoarding(ActionEvent event) {
	    	air.orderBoardingGates();

	    }

	    @FXML
	    void orderDateTime(ActionEvent event) {
	    	air.orderDateTime();
	    }

	    @FXML
	    void orderDestination(ActionEvent event) {
	    	air.orderDestination();
	    }

	    @FXML
	    void orderNumber(ActionEvent event) {
	    	air.orderNumberFlight();
	    }
	    
	    @FXML
	    void searchAirline(ActionEvent event) {
			 Flight bus =  air.searchByAirline(txt.getText());
			 txtArea.setText(""+bus);

	    }

	    @FXML
	    void searchBoarding(ActionEvent event) {
	    	Flight bus=  air.searchbyBoardingGate(Integer.parseInt(txt.getText()));
	    	 txtArea.setText(""+bus);
	    }

	    @FXML
	    void searchDateTime(ActionEvent event) {
	   	 Flight bus =  air.searchByDateTime(txt.getText());
	   	 txtArea.setText(""+bus);
	    }

	    @FXML
	    void searchDestination(ActionEvent event) {
	    	Flight bus =  air.searchByDestination(txt.getText());
	    	 txtArea.setText(""+bus);

	    }

	    @FXML
	    void searchNumber(ActionEvent event) {
	    	Flight bus =  air.searchbyNumberFlight(Integer.parseInt(txt.getText()));
	    	 txtArea.setText(""+bus);

	    }
	    
	    public void list() throws IOException{
	    	
	    	ObservableList<Flight> listas =  air.loadTxt();
	    	
	    	fechas.setCellValueFactory(new PropertyValueFactory<Flight,LocalDateTime>("Fecha&Hora"));
			aerolineas.setCellValueFactory( new PropertyValueFactory<Flight, String>("Aerolinea"));
			num.setCellValueFactory( new PropertyValueFactory<Flight, Integer>("Vuelo"));
			destinos.setCellValueFactory( new PropertyValueFactory<Flight, String>("Destino"));
			puertas.setCellValueFactory( new PropertyValueFactory<Flight, Integer>("Puerta de embarque"));
			
			list.setItems(listas);
			pagination.getChildrenUnmodifiable().addAll(list);
		
			System.out.print(" "+ listas.toString());	
		} 
	    
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			air=new Airport();
//			try {
//				list();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}


}
