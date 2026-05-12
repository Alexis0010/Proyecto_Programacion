package casaRural;

public class Habitacion {
    protected int id;
    protected int numero;
    protected TipoHabitacion tipo;
    protected int capacidad;
    protected int precioNoche;
    protected String descripcion;

    public Habitacion(TipoHabitacion tipo, int id, int numero, int capacidad, int precioNoche, String descripcion) {
        this.tipo = tipo;
        this.id = id;
        this.numero = numero;
        this.capacidad = capacidad;
        this.precioNoche = precioNoche;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(int precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
