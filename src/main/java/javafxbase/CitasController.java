package javafxbase;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.*;

public class CitasController extends Cambios implements Initializable {

    @FXML
    private TableColumn<Cita, String> columnaFecha;
    @FXML
    private TableColumn<Cita, String> columnaHora;
    @FXML
    private TableColumn<Cita, String> columnaCliente;
    @FXML
    private TableColumn<Cita, String> columnaEmpleado;
    @FXML
    private TableColumn<Cita, String> columnaCedula;
    @FXML
    private TableColumn<Cita, String> columnaServicio;
    @FXML
    private TextField campoFecha;
    @FXML
    private TextField campoCedula;
    @FXML
    private TextField campoHora;
    @FXML
    private TextField campoCliente;
    @FXML
    private TextField campoEmpleado;
    @FXML
    private ComboBox<String> comboBoxServicio;
    @FXML
    private TableView<Cita> tablaCitas;

    ArrayList<String> servicios = Servicio.listaServiciosParaCitas();
    ArrayList<Cita> citas = Cita.cargarLista();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxServicio.getItems().addAll(servicios);
        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnaHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        columnaCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        columnaEmpleado.setCellValueFactory(new PropertyValueFactory<>("empleado"));
        columnaServicio.setCellValueFactory(new PropertyValueFactory<>("servicio"));
        columnaCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        tablaCitas.getItems().setAll(citas);
    }
    
    @FXML
    public void crearCita(ActionEvent event){
        String cedula=campoCedula.getText();
        String fecha=campoFecha.getText();
        String hora=campoHora.getText();
        String cliente=campoCliente.getText();
        String empleado=campoEmpleado.getText();
        String servicio=comboBoxServicio.getValue();
        int validador = 0;
        for(Cita c :citas){
            if (c.getFecha().equals(fecha) && c.getHora().equals(hora)&& c.getEmpleado().equals(empleado)){
                validador++;
            }
        }
        if (validador!=0){
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Citas");
            alerta.setTitle("Cita Errónea");
            alerta.setHeaderText("Ya hay una cita a esta hora");
            alerta.showAndWait();
        }
        else{
        Cita cita =new Cita(cedula,fecha,hora,cliente,servicio,empleado);
        citas.add(cita);
        tablaCitas.getItems().setAll(citas);
        Cita.sobreescribirFichero(citas);
        reestablecer(campoCedula,campoFecha,campoHora,campoCliente,campoEmpleado,comboBoxServicio);
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Citas");
        alerta.setHeaderText("Su cita ha sido creada");
        alerta.showAndWait();
        }
    }
    
    @FXML
    public void eliminarCita(ActionEvent event) throws IOException{
        App.setRoot("eliminarCitas");
    }
    
    @FXML
    public void consultarCita(ActionEvent event) throws IOException{
        App.setRoot("consultarCitas");
    }
    
    private static void reestablecer(TextField c1,TextField c2,TextField c3,TextField c4, TextField c5, ComboBox<String> c){
        c1.setText(null);
        c2.setText(null);
        c3.setText(null);
        c4.setText(null);
        c5.setText(null);
        c.setValue(null);
    }
}
