package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Servicio;

public class ServiciosController extends Cambios implements Initializable {


    @FXML
    private TableColumn<Servicio, String> columnaNombre;
    @FXML
    private TableColumn<Servicio, String> columnaDuracion;
    @FXML
    private TableColumn<Servicio, String> columnaPrecio;
    @FXML
    private TableColumn<Servicio, String> columnaEstado;
    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoDuracion;
    @FXML
    private ComboBox<String> comboBoxServicios;
    @FXML
    private TextField campoPrecio;
    @FXML
    private TableView<Servicio> tablaServicios;
    ArrayList<Servicio> servicios = Servicio.cargarLista();
    String[] strings = {"Activo","Inactivo"};
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxServicios.getItems().addAll(strings);
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        columnaPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        columnaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tablaServicios.getItems().setAll(servicios);
    }    
    
    @FXML
    private void agregarServicios(ActionEvent event) {
        System.out.println("agg");
        String nombre = campoNombre.getText();
        int duracion = Integer.parseInt(campoDuracion.getText());
        double precio = Double.parseDouble(campoPrecio.getText());
        String estado = comboBoxServicios.getValue();
        servicios.add(new Servicio(nombre,duracion,precio,App.stringABoolean(estado)));
        tablaServicios.getItems().setAll(servicios);
        Servicio.sobreescribirFichero(servicios);
        reestablecer(campoNombre,campoPrecio,campoDuracion,comboBoxServicios);
    }
    
    @FXML
    private void seleccionarServicio(ActionEvent event) {
        comboBoxServicios.setDisable(true);
        String nuevoNombre = servicios.get(tablaServicios.getSelectionModel().getSelectedIndex()).getNombre();
        int nuevaDuracion = servicios.get(tablaServicios.getSelectionModel().getSelectedIndex()).getDuracion();
        double nuevoPrecio = servicios.get(tablaServicios.getSelectionModel().getSelectedIndex()).getPrecio();
        campoNombre.setText(nuevoNombre);
        campoPrecio.setText(String.valueOf(nuevoPrecio));
        campoDuracion.setText(String.valueOf(nuevaDuracion));
    }
    
    @FXML
    private void editarServicios(ActionEvent event) {
        String nuevoNombre = servicios.get(tablaServicios.getSelectionModel().getSelectedIndex()).getNombre();
        int nuevaDuracion = servicios.get(tablaServicios.getSelectionModel().getSelectedIndex()).getDuracion();
        double nuevoPrecio = servicios.get(tablaServicios.getSelectionModel().getSelectedIndex()).getPrecio();
        boolean estadoActual = servicios.get(tablaServicios.getSelectionModel().getSelectedIndex()).getEstadoNormal();
        
        if(!campoNombre.getText().isEmpty()){
            nuevoNombre = campoNombre.getText();
        }
        if(!campoDuracion.getText().isEmpty()){
            nuevaDuracion = Integer.parseInt(campoDuracion.getText());
        }
        if(!campoPrecio.getText().isEmpty()){
            nuevoPrecio = Double.parseDouble(campoPrecio.getText());
        }
        servicios.set(tablaServicios.getSelectionModel().getSelectedIndex(),new Servicio(nuevoNombre,nuevaDuracion,nuevoPrecio,estadoActual));
        tablaServicios.getItems().setAll(servicios);
        Servicio.sobreescribirFichero(servicios);
        comboBoxServicios.setDisable(false);
        reestablecer(campoNombre,campoPrecio,campoDuracion,comboBoxServicios);
    }
    
    @FXML
    private void eliminarServicios(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Eliminando Servicio");
        alerta.setHeaderText("Esta seguro de eliminar este servicio?");
        alerta.setContentText("Presione en 'ACEPTAR' para validar la acción \nCaso contrario presione 'CANCELAR'");
        Optional<ButtonType> result = alerta.showAndWait();
        if(result.get() == ButtonType.OK){
            boolean cambioEstado = servicios.get(tablaServicios.getSelectionModel().getSelectedIndex()).getEstadoNormal();
            servicios.get(tablaServicios.getSelectionModel().getSelectedIndex()).setEstado(false);
            tablaServicios.getItems().setAll(servicios);
            Servicio.sobreescribirFichero(servicios);
        }
    }
    
    private static void reestablecer(TextField c1,TextField c2,TextField c3, ComboBox<String> c){
        c1.setText(null);
        c2.setText(null);
        c3.setText(null);
        c.setValue(null);
    }
}
