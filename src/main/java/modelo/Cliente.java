
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafxbase.App;

public class Cliente extends Persona{ 
    private String representante;
    
    public Cliente(String cedula, String nombre, String telefono, String email, String representante){
        super(cedula,nombre,telefono,email);
        this.representante = representante;
    }

    public String getRepresentante() {
        return representante;
    }

    
    public static ArrayList<Cliente> cargarLista(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\NetBeans-14\\Proyecto\\src\\main\\resources\\Clientes.txt"));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                clientes.add(new Cliente(datos[0],datos[1],datos[2],datos[3],datos[4]));
            }
        }catch (IOException e){
            
        }
        return clientes;
    }
    
    public static void sobreescribirFichero(ArrayList<Cliente> clientes){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:/NetBeans-14/Proyecto/src/main/resources/Clientes.txt"));){
            bw.write("Cédula,nombre,telefono,email,representante");
            for(Cliente c:clientes){
                bw.newLine();
                bw.write(c.getCedula()+","+c.getNombre()+","+c.getTelefono()+","+c.getEmail()+","+c.representante);
            }
        }catch (IOException e){
            System.out.println("error");
        }
    }
}
