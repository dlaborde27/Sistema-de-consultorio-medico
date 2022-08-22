package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javafxbase.App;

public class Empleado extends Persona implements Serializable{
    private boolean estado;
    private static final long serialVersionUID = 1L;
    
    public Empleado(String cedula, String nombre, String telefono, String email, boolean estado){
        super(cedula,nombre,telefono,email);
        this.estado = estado;
    }
    
    public String getEstado() {
        return estado?"Activo":"Inactivo";
    }
    
    public boolean getEstadoNormal() {
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public static ArrayList<Empleado> cargarLista(){
        ArrayList<Empleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\NetBeans-14\\Proyecto\\src\\main\\resources\\Empleados.txt"));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                empleados.add(new Empleado(datos[0],datos[1],datos[2],datos[3],App.stringABoolean(datos[4])));
            }
        }catch (IOException e){
            
        }
        return empleados;
    }
    

    public static void sobreescribirFichero(ArrayList<Empleado> empleados){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:/NetBeans-14/Proyecto/src/main/resources/Empleados.txt"));){
            bw.write("Cédula,nombre,telefono,email,estado");
            for(Empleado e:empleados){
                bw.newLine();
                bw.write(e.getCedula()+","+e.getNombre()+","+e.getTelefono()+","+e.getEmail()+","+e.estado);
            }
        }catch (IOException e){
            System.out.println("error");
        }
    }
}