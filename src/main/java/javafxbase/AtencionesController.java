/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Atencion;
import modelo.Cita;

/**
 * FXML Controller class
 *
 * @author Lucas
 */
public class AtencionesController extends Cambios implements Initializable {

    @FXML
    private TableView<Atencion> tablaAtencion;
    @FXML
    private TableColumn<Atencion, String> columnaNombre;
    @FXML
    private TableColumn<Atencion, String> columnaDuracion;
    @FXML
    private TableColumn<Atencion, Cita> columnaServicio;
    @FXML
    private TableColumn<Atencion,String> columnaFecha;

  
    ArrayList<Atencion> atenciones = Atencion.cargarLista();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
    private void registrarAtencion(ActionEvent event) throws IOException {
     App.setRoot("registrarAtencion");    
    }
    
    
}
