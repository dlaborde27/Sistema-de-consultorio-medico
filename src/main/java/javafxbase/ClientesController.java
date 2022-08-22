package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cliente;

public class ClientesController extends Cambios implements Initializable {
    
    @FXML
    private TableColumn<Cliente, String> columnaNombre;
    @FXML
    private TableColumn<Cliente, String> columnaCedula;
    @FXML
    private TableColumn<Cliente, String> columnaTelefono;
    @FXML
    private TableColumn<Cliente, String> columnaEmail;
    @FXML
    private TableColumn<Cliente, String> columnaRepresentante;
    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoCedula;
    @FXML
    private TextField campoTelefono;
    @FXML
    private TextField campoEmail;
    @FXML
    private TextField campoRepresentante;
    @FXML
    private TableView<Cliente> tablaClientes;
    
    ArrayList<Cliente> clientes = Cliente.cargarLista();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnaRepresentante.setCellValueFactory(new PropertyValueFactory<>("representante"));
        tablaClientes.getItems().setAll(clientes);
    }    
    
    @FXML
    private void agregarCliente(ActionEvent event) {
        String nombre = campoNombre.getText();
        String cedula = campoCedula.getText();
        String email = campoEmail.getText();
        String telefono = campoTelefono.getText();
        String representante = campoRepresentante.getText();
        clientes.add(new Cliente(cedula,nombre,telefono,email,representante));
        tablaClientes.getItems().setAll(clientes);
        Cliente.sobreescribirFichero(clientes);
        reestablecer(campoNombre,campoCedula,campoTelefono,campoEmail,campoRepresentante);
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Cliente Registrado");
        alerta.setHeaderText("Su cliente ha sido agregado");
        alerta.showAndWait();
    }
    
    @FXML
    private void seleccionarCliente(ActionEvent event) {
        String nombreElegido = clientes.get(tablaClientes.getSelectionModel().getSelectedIndex()).getNombre();
        String emailElegido = clientes.get(tablaClientes.getSelectionModel().getSelectedIndex()).getEmail();
        String cedulaElegida = clientes.get(tablaClientes.getSelectionModel().getSelectedIndex()).getCedula();
        String telefonoElegido = clientes.get(tablaClientes.getSelectionModel().getSelectedIndex()).getTelefono();
        String representanteElegido = clientes.get(tablaClientes.getSelectionModel().getSelectedIndex()).getRepresentante();
        campoNombre.setText(nombreElegido);
        campoEmail.setText(emailElegido);
        campoCedula.setText(String.valueOf(cedulaElegida));
        campoTelefono.setText(telefonoElegido);
        campoRepresentante.setText(representanteElegido);
    }
    
    @FXML
    private void editarCliente(ActionEvent event) {
        String nombreElegido = clientes.get(tablaClientes.getSelectionModel().getSelectedIndex()).getNombre();
        String emailElegido = clientes.get(tablaClientes.getSelectionModel().getSelectedIndex()).getEmail();
        String cedulaElegida = clientes.get(tablaClientes.getSelectionModel().getSelectedIndex()).getCedula();
        String telefonoElegido = clientes.get(tablaClientes.getSelectionModel().getSelectedIndex()).getTelefono();
        String representanteElegido = clientes.get(tablaClientes.getSelectionModel().getSelectedIndex()).getRepresentante();
        
        if(!campoNombre.getText().isEmpty()){
            nombreElegido = campoNombre.getText();
        }
        if(!campoEmail.getText().isEmpty()){
            emailElegido = campoEmail.getText();
        }
        if(!campoCedula.getText().isEmpty()){
            cedulaElegida = campoCedula.getText();
        }
        if(!campoTelefono.getText().isEmpty()){
            telefonoElegido = campoTelefono.getText();
        }
        if(!campoRepresentante.getText().isEmpty()){
            representanteElegido = campoRepresentante.getText();
        }
        
        clientes.set(tablaClientes.getSelectionModel().getSelectedIndex(),new Cliente(cedulaElegida,nombreElegido,telefonoElegido,emailElegido,representanteElegido));
        tablaClientes.getItems().setAll(clientes);
        Cliente.sobreescribirFichero(clientes);
        reestablecer(campoNombre,campoCedula,campoTelefono,campoEmail,campoRepresentante);
    }

    private static void reestablecer(TextField c1,TextField c2,TextField c3,TextField c4, TextField c5){
        c1.setText(null);
        c2.setText(null);
        c3.setText(null);
        c4.setText(null);
        c5.setText(null);
    }
}
