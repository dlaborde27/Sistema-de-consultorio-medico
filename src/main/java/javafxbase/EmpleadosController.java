package javafxbase;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import modelo.Empleado;
import modelo.Servicio;

public class EmpleadosController extends Cambios implements Initializable {
    
    @FXML
    private TableColumn<Empleado, String> columnaNombre;
    @FXML
    private TableColumn<Empleado, String> columnaCedula;
    @FXML
    private TableColumn<Empleado, String> columnaTelefono;
    @FXML
    private TableColumn<Empleado, String> columnaEmail;
    @FXML
    private TableColumn<Empleado, String> columnaEstado;
    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoCedula;
    @FXML
    private TextField campoTelefono;
    @FXML
    private TextField campoEmail;
    @FXML
    private ComboBox<String> comboBoxServicios;
    @FXML
    private TableView<Empleado> tablaEmpleados;
    
    ArrayList<Empleado> empleados = new ArrayList<>();
    String[] strings = {"Activo","Inactivo"};
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxServicios.getItems().addAll(strings);
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tablaEmpleados.getItems().setAll(empleados = Empleado.cargarLista());
    }    
    
    @FXML
    private void agregarEmpleado(ActionEvent event) {
        String nombre = campoNombre.getText();
        String cedula = campoCedula.getText();
        String email = campoEmail.getText();
        String telefono = campoTelefono.getText();
        String estado = comboBoxServicios.getValue();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:/NetBeans-14/Proyecto/src/main/resources/Empleados.txt",true));){
            bw.newLine();
            bw.write(cedula+","+nombre+","+telefono+","+email+","+estado);
        }catch (IOException e){
            System.out.println("error");
        }
        tablaEmpleados.getItems().setAll(empleados = Empleado.cargarLista());
        /*try(ObjectOutputStream serializar=new ObjectOutputStream(new FileOutputStream("D:/NetBeans-14/Proyecto/src/main/resources/EmpleadosSerializados.txt"))){
          serializar.writeObject(empleados);
        }catch(IOException e){
          System.out.print(e.getMessage());
        }
        */
        /*try(ObjectInputStream deserializar=new ObjectInputStream(new FileInputStream("D:/NetBeans-14/Proyecto/src/main/resources/EmpleadosSerializados.txt"))){
            empleados = (ArrayList<Empleado>) deserializar.readObject();
            for(Empleado e: empleados){
            System.out.println(e.toString());
        }
        }catch(Exception e){
          System.out.print(e.getMessage());   
        }*/
        
        reestablecer(campoNombre,campoCedula,campoTelefono,campoEmail,comboBoxServicios);
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Empleado agregado");
        alerta.setHeaderText("Su empleado ha sido agregado");
        alerta.showAndWait();     
    }
    
    @FXML
    private void editarEmpleado(ActionEvent event) {
        String nombreElegido = empleados.get(tablaEmpleados.getSelectionModel().getSelectedIndex()).getNombre();
        String emailElegido = empleados.get(tablaEmpleados.getSelectionModel().getSelectedIndex()).getEmail();
        String cedulaElegida = empleados.get(tablaEmpleados.getSelectionModel().getSelectedIndex()).getCedula();
        String telefonoElegido = empleados.get(tablaEmpleados.getSelectionModel().getSelectedIndex()).getTelefono();
        boolean estadoActual = empleados.get(tablaEmpleados.getSelectionModel().getSelectedIndex()).getEstadoNormal();
        
        if(!campoNombre.getText().isEmpty()){
            nombreElegido = campoNombre.getText();
        }
        if(!campoEmail.getText().isEmpty()){
            emailElegido = campoNombre.getText();
        }
        if(!campoCedula.getText().isEmpty()){
            cedulaElegida = campoCedula.getText();
        }
        if(!campoTelefono.getText().isEmpty()){
            telefonoElegido = campoTelefono.getText();
        }
        
        empleados.set(tablaEmpleados.getSelectionModel().getSelectedIndex(),new Empleado(cedulaElegida,nombreElegido,telefonoElegido,emailElegido,estadoActual));
        tablaEmpleados.getItems().setAll(empleados);
        comboBoxServicios.setDisable(false);
        
        /*try(ObjectOutputStream serializar=new ObjectOutputStream(new FileOutputStream("D:/NetBeans-14/Proyecto/src/main/resources/EmpleadosSerializados.txt"))){
          serializar.writeObject(empleados);
        }catch(IOException e){
          System.out.print(e.getMessage());
        }*/
        
        Empleado.sobreescribirFichero(empleados);
        reestablecer(campoNombre,campoCedula,campoTelefono,campoEmail,comboBoxServicios);
    }
    
    @FXML
    private void eliminarEmpleado(ActionEvent event) {
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle("Eliminando Empleado");
        alerta.setHeaderText("Esta seguro de eliminar este usuario?");
        alerta.setContentText("Presione en 'ACEPTAR' para validar la acción \nCaso contrario presione 'CANCELAR'");
        Optional<ButtonType> result = alerta.showAndWait();
        if(result.get() == ButtonType.OK){
            boolean cambioEstado = empleados.get(tablaEmpleados.getSelectionModel().getSelectedIndex()).getEstadoNormal();
            empleados.get(tablaEmpleados.getSelectionModel().getSelectedIndex()).setEstado(false);
            tablaEmpleados.getItems().setAll(empleados);
            Empleado.sobreescribirFichero(empleados);
            reestablecer(campoNombre,campoCedula,campoTelefono,campoEmail,comboBoxServicios);
        }
    }
    
    @FXML
    private void seleccionarEmpleado(ActionEvent event) {
        comboBoxServicios.setDisable(true);
        String nombreElegido = empleados.get(tablaEmpleados.getSelectionModel().getSelectedIndex()).getNombre();
        String emailElegido = empleados.get(tablaEmpleados.getSelectionModel().getSelectedIndex()).getEmail();
        String cedulaElegida = empleados.get(tablaEmpleados.getSelectionModel().getSelectedIndex()).getCedula();
        String telefonoElegido = empleados.get(tablaEmpleados.getSelectionModel().getSelectedIndex()).getTelefono();
        campoNombre.setText(nombreElegido);
        campoEmail.setText(emailElegido);
        campoCedula.setText(String.valueOf(cedulaElegida));
        campoTelefono.setText(telefonoElegido);
    }
    
    
    private static void reestablecer(TextField c1,TextField c2,TextField c3,TextField c4, ComboBox<String> c){
        c1.setText(null);
        c2.setText(null);
        c3.setText(null);
        c4.setText(null);
        c.setValue(null);
    }
}
