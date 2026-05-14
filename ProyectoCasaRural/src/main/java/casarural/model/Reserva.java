package casarural.model;

import java.time.LocalDate;

public class Reserva {
    protected int id;
    protected LocalDate fechaEntrada;
    protected LocalDate fechaFin;
    protected int numeroPersonas;
    protected String estado;
    protected String observaciones;
    protected int clienteId;
    protected int habitacionId;

    public Reserva() {
    }

    public Reserva(int id, LocalDate fechaEntrada, LocalDate fechaFin, int numeroPersonas, String estado, String observaciones, int clienteId, int habitacionId) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaFin = fechaFin;
        this.numeroPersonas = numeroPersonas;
        this.estado = estado;
        this.observaciones = observaciones;
        this.clienteId = clienteId;
        this.habitacionId = habitacionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(int habitacionId) {
        this.habitacionId = habitacionId;
    }
}
