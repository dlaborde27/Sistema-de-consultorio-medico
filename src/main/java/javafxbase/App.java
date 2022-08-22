package javafxbase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("menu"), 781, 430);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Boolean stringABoolean(String estado){
        Boolean verificacion;
        if (estado.equals("Activo")){
            verificacion = true;
        } else{
            verificacion = false;
        }
        return verificacion;
    }
    public static void serializacionn(String ruta, ArrayList<?> lista){
        try(ObjectOutputStream serializar=new ObjectOutputStream(new FileOutputStream(ruta))){
          serializar.writeObject(lista);
        }catch(IOException e){
          System.out.print(e.getMessage());
        }
    } 
    public static ArrayList<?> deserializacionn(String ruta){
        ArrayList<?> lista = new ArrayList<>();
        try(ObjectInputStream deserializar=new ObjectInputStream(new FileInputStream(ruta))){
            lista = (ArrayList<?>) deserializar.readObject();
        }catch(Exception e){
          System.out.print(e.getMessage());   
        }
        return lista;
    } 
}



/*package javafxbase;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cita;
/**
 * FXML Controller class
 *
 * @author Pc
 /*
*/
/*
public class EliminarCitasController extends Cambios implements Initializable {

    @FXML
    private TextField campoCedula;
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
    private void eliminarCita(ActionEvent event) {
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle("Eliminando Cita");
        alerta.setHeaderText("Esta seguro de eliminar esta cita?");
        alerta.setContentText("Presione en 'ACEPTAR' para validar la acción \nCaso contrario presione 'CANCELAR'");
        Optional<ButtonType> result = alerta.showAndWait();
        if(result.get() == ButtonType.OK){
            /*String fechaDelElegido = tablaCitas.getSelectionModel().getSelectedItem().getFecha();
            String horaDelElegido = tablaCitas.getSelectionModel().getSelectedItem().getHora();
            String empleadoDelElegido = tablaCitas.getSelectionModel().getSelectedItem().getEmpleado();*//*
            Cita citaElegida = tablaCitas.getSelectionModel().getSelectedItem();
            citas.remove(citaElegida);
            tablaCitas.getItems().setAll(citas);
            Cita.sobreescribirFichero(citas);
            campoCedula.setText(null);
        }
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("citas");
    }

    @FXML
    private void buscarCita(ActionEvent event) {
        ArrayList<Cita> discriminante = new ArrayList<>();
        for (Cita c : citas){
            if (c.getCedula().equals(campoCedula.getText())){
                discriminante.add(c);
            }
        }
        tablaCitas.getItems().setAll(discriminante);
    }

}*/
