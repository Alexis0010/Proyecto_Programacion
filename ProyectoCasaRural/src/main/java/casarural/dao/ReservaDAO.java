package casarural.dao;

import casarural.model.Reserva;
import casarural.util.DatabaseConnection;

import java.sql.*;

public class ReservaDAO {

    public void insertar(Reserva r) throws SQLException {
        String sql = "INSERT INTO reservas (fecha_entrada, fecha_fin, numero_personas, estado, observaciones, cliente_id, habitacion_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(r.getFechaEntrada()));
            ps.setDate(2, Date.valueOf(r.getFechaFin()));
            ps.setInt(3, r.getNumeroPersonas());
            ps.setString(4, r.getEstado());
            ps.setString(5, r.getObservaciones());
            ps.setInt(6, r.getClienteId());
            ps.setInt(7, r.getHabitacionId());
            ps.executeUpdate();
        }
    }
}