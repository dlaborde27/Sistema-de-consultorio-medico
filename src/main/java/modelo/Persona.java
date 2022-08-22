package modelo;

public abstract class Persona{
    private String cedula;
    private String nombre;
    private String telefono;
    private String email;
    
    public Persona(String cedula, String nombre, String telefono, String email){
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }


    public String getEmail() {
        return email;
    }
    
    @Override 
    public String toString(){
        return "Numero de cedula: "+cedula+", nombre: "+nombre+", telefono: "+telefono+", email: "+email;
    }
}