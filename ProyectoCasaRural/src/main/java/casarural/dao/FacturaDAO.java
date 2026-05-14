package casarural.dao;

import casarural.model.Factura;
import casarural.util.DatabaseConnection;

import java.sql.*;

public class FacturaDAO {

    public void insertar(Factura f) throws SQLException {
        String sql = "INSERT INTO facturas (fecha_emision, concepto, base_imponible, iva, total, reserva_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(f.getFechaEmision()));
            ps.setString(2, f.getConcepto());
            ps.setDouble(3, f.getBaseImponible());
            ps.setDouble(4, f.getIva());
            ps.setDouble(5, f.getTotal());
            ps.setInt(6, f.getReservaId());
            ps.executeUpdate();
        }
    }
}