/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cita;
import modelo.Empleado;


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
    private void buscarCita(ActionEvent event) {
        ArrayList<Cita> discriminante = new ArrayList<>();
        for (Cita c : citas){
            if (c.getCedula().equals(campoCedula.getText())){
                discriminante.add(c);
            }
        }
        tablaCitas.getItems().setAll(discriminante);
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("citas");
    }

    @FXML
    private void eliminarCita(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Eliminando Cita");
        alerta.setHeaderText("Esta seguro de eliminar esta cita?");
        alerta.setContentText("Presione en 'ACEPTAR' para validar la acción \nCaso contrario presione 'CANCELAR'");
        Optional<ButtonType> result = alerta.showAndWait();
        if(result.get() == ButtonType.OK){
            Cita citaElegida = tablaCitas.getSelectionModel().getSelectedItem();
            citas.remove(citaElegida);
            tablaCitas.getItems().setAll(citas);
            Cita.sobreescribirFichero(citas);
            campoCedula.setText(null);
        }
    }

}
