package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafxbase.App;

public class Servicio{
    private String nombre;
    private int duracion;
    private double precio;
    private boolean estado;

    public Servicio(String nombre, int duracion, double precio, boolean estado) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
        this.estado = estado;
    }
    public Servicio (boolean estado){
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", duracion: " + duracion +" min "+", precio: $" + precio + ", estado: " + estado;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public double getPrecio() {
        return precio;
    }
    
    public String getEstado() {
        return estado?"Activo":"Inactivo";
    }
    
    public boolean getEstadoNormal() {
        return estado;
    }
    
    public static ArrayList<Servicio> cargarLista(){
        ArrayList<Servicio> servicios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\NetBeans-14\\Proyecto\\src\\main\\resources\\Servicios.txt"));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                servicios.add(new Servicio(datos[0],Integer.parseInt(datos[1]),Double.parseDouble(datos[2]),App.stringABoolean(datos[3])));
            }
        }catch (IOException e){
            
        }
        return servicios;
    }
    
    public static ArrayList<String> listaServiciosParaCitas() {
       ArrayList<String> nombres = new ArrayList<>();
       ArrayList<Servicio> servicios = cargarLista();
        for(Servicio s: servicios){
            nombres.add(s.nombre);
        }
        return nombres;
    }
    
    public static void sobreescribirFichero(ArrayList<Servicio> servicios){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:/NetBeans-14/Proyecto/src/main/resources/Servicios.txt"));){
            bw.write("Cédula,nombre,telefono,email,estado");
            for(Servicio s:servicios){
                bw.newLine();
                bw.write(s.nombre+","+s.duracion+","+s.precio+","+s.estado);
            }
        }catch (IOException e){
            System.out.println("error");
        }
    }
}