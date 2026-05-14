package casarural.model;

import java.time.LocalDate;

public class Factura {
    protected int numeroFactura;
    protected LocalDate fechaEmision;
    protected String concepto;
    protected double baseImponible;
    protected double iva;
    protected double total;
    protected int reservaId;

    public Factura() {}

    public Factura(int numeroFactura, LocalDate fechaEmision, String concepto, double baseImponible, double iva, double total, int reservaId) {
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.concepto = concepto;
        this.baseImponible = baseImponible;
        this.iva = iva;
        this.total = total;
        this.reservaId = reservaId;
    }

    public int getNumeroFactura() { return numeroFactura; }
    public void setNumeroFactura(int numeroFactura) { this.numeroFactura = numeroFactura; }

    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }

    public String getConcepto() { return concepto; }
    public void setConcepto(String concepto) { this.concepto = concepto; }

    public double getBaseImponible() { return baseImponible; }
    public void setBaseImponible(double baseImponible) { this.baseImponible = baseImponible; }

    public double getIva() { return iva; }
    public void setIva(double iva) { this.iva = iva; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public int getReservaId() { return reservaId; }
    public void setReservaId(int reservaId) { this.reservaId = reservaId; }
}
