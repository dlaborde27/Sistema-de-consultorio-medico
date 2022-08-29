
package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import modelo.Cita;
public class Atencion {

    private String duracion;
    private String empleado;
    private Cita cita;
    private String fecha;

    public Atencion(String empleado,String duracion, Cita cita, String fecha) {
        this.duracion = duracion;
        this.empleado = empleado;
        this.cita = cita;
        this.fecha=fecha;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getEmpleado() {
        return empleado;
    }

    public Cita getCita() {
        return cita;
    }

    public String getFecha() {
        return fecha;
    }
    
    
       public static ArrayList<Atencion> cargarLista(){
        ArrayList<Atencion> atenciones = new ArrayList<>();
       
        
        atenciones.add(new Atencion("Zinedine Zidane ","50",new Cita("0958985160","2022/08/10","08:20","Juan Ferdandez Velasquez","Psicologia","Zinedine Zidane"),"20/08/2002"));
        
        return atenciones;
       }
}
