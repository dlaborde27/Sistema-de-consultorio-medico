package javafxbase;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public abstract class Cambios {
    @FXML
    public void botonEmpleados(ActionEvent event) throws IOException{
        App.setRoot("empleados");
    }
    @FXML
    public void botonClientes(ActionEvent event) throws IOException{
        App.setRoot("clientes");
    }
    @FXML
    public void botonServicios(ActionEvent event) throws IOException{
        App.setRoot("servicios");
    }
    @FXML
    public void botonCitas(ActionEvent event) throws IOException{
        App.setRoot("citas");
    }
}
