/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxbase;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lucas
 */
public class AtencionesController extends Cambios implements Initializable {

    @FXML
    private TableView<?> tablaCitas;
    @FXML
    private TableColumn<?, ?> columnaCedula;
    @FXML
    private TableColumn<?, ?> columnaDuracion;
    @FXML
    private TableColumn<?, ?> columnaEmpleado;
    @FXML
    private TextField cedulaTxt;
    @FXML
    private TextField duracionTxt;
    @FXML
    private TextField empleadoTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void crearAtencion(ActionEvent event) {
    }

    @FXML
    private void consultarAtencion(ActionEvent event) {
    }
    
}
