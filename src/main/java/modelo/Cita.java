package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cita {
   private String fecha;
   private String hora;
   private String cedula;
   private String cliente;
   private String empleado;
   private String servicio;
   
   public Cita(String cedula, String fecha, String hora, String cliente, String servicio, String empleado) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.cedula = cedula;
        this.empleado = empleado;
        this.servicio = servicio;
    }
   
    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }
    
    public String getCedula() {
        return cedula;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEmpleado() {
        return empleado;
    }

    public String getServicio() {
        return servicio;
    }


    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "Cita{" + "fecha=" + fecha + ", hora=" + hora + ", cedula=" + cedula + ", cliente=" + cliente + ", empleado=" + empleado + ", servicio=" + servicio + '}';
    }
    
    
    
    public static ArrayList<Cita> cargarLista(){
        ArrayList<Cita> citas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\NetBeans-14\\Proyecto\\src\\main\\resources\\Citas.txt"));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                citas.add(new Cita(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5]));
            }
        }catch (IOException e){
            
        }
        return citas;
    }
    
    public static void sobreescribirFichero(ArrayList<Cita> citas){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:/NetBeans-14/Proyecto/src/main/resources/Citas.txt"));){
            bw.write("Cédula,fecha,hora,cliente,servicio,empleado");
            for(Cita c:citas){
                bw.newLine();
                bw.write(c.cedula+","+c.fecha+","+c.hora+","+c.cliente+","+c.servicio+","+c.empleado);
            }
        }catch (IOException e){
            System.out.println("error");
        }
    }
}
