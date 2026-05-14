package casarural.model;

public class Cliente {
    protected int id;
    protected String nombre;
    protected String telefono;
    protected String email;
    protected String dni;

    public Cliente(){}
    public Cliente(int id, String nombre, String telefono, String email, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.dni = dni;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

}
