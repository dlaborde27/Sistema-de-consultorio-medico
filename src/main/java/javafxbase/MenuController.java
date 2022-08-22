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
import java.io.*;


public class MenuController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void botonServicios(ActionEvent event) throws IOException{
        App.setRoot("servicios");
    }

    @FXML
    private void botonEmpleados(ActionEvent event) throws IOException{
        App.setRoot("empleados");
    }

    @FXML
    private void botonClientes(ActionEvent event) {
    }

    @FXML
    private void botonCitas(ActionEvent event) {
    }

    @FXML
    private void botonAtencion(ActionEvent event) {
    }

    @FXML
    private void botonSalir(ActionEvent event) {
    }

}
