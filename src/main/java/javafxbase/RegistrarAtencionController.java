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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author Lucas
 */
public class RegistrarAtencionController extends Cambios implements Initializable {
   


    @FXML
    private AnchorPane fechaText;
    @FXML
    private TextField duracion;
    @FXML
    private TextField cliente;
    @FXML
    private TextField terapista;
    @FXML
    private TextArea fechatexto;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
               
    }    

    

}
