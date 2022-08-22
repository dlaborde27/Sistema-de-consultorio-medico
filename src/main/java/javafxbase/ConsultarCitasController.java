package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cita;



public class ConsultarCitasController extends Cambios implements Initializable {

    @FXML
    private TextField campoFecha;
    @FXML
    private TableView<Cita> tablaCitas;
    @FXML
    private TableColumn<Cita, String> columnaFecha;
    @FXML
    private TableColumn<Cita, String> columnaHora;
    @FXML
    private TableColumn<Cita, String> columnaCliente;
    @FXML
    private TableColumn<Cita, String> columnaEmpleado;
    @FXML
    private TableColumn<Cita, String> columnaServicio;
    @FXML
    private TableColumn<Cita, String> columnaCedula;
    ArrayList<Cita> citas = Cita.cargarLista();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnaHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        columnaCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        columnaEmpleado.setCellValueFactory(new PropertyValueFactory<>("empleado"));
        columnaServicio.setCellValueFactory(new PropertyValueFactory<>("servicio"));
        columnaCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        tablaCitas.getItems().setAll(citas);
    }    
    
    @FXML
    private void buscarCita(ActionEvent event) {
        ArrayList<Cita> discriminante = new ArrayList<>();
        for (Cita c : citas){
            if (c.getFecha().equals(campoFecha.getText())){
                discriminante.add(c);
            }
        }
        tablaCitas.getItems().setAll(discriminante);
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("citas");
    }

}
