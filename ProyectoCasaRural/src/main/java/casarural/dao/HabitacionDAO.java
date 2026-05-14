package casarural.dao;

import casarural.model.Habitacion;
import casarural.model.TipoHabitacion;
import casarural.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitacionDAO {

    public void insertar(Habitacion h) throws SQLException {
        String sql = "INSERT INTO habitaciones (numero, tipo, capacidad, precio_noche, descripcion) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, h.getNumero());
            ps.setString(2, h.getTipo().name());
            ps.setInt(3, h.getCapacidad());
            ps.setDouble(4, h.getPrecioNoche());
            ps.setString(5, h.getDescripcion());
            ps.executeUpdate();
        }
    }

    public List<Habitacion> listarTodas() throws SQLException {
        List<Habitacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM habitaciones";
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Habitacion(
                    rs.getInt("id"),
                    rs.getString("numero"),
                    TipoHabitacion.valueOf(rs.getString("tipo").toUpperCase()),
                    rs.getInt("capacidad"),
                    rs.getDouble("precio_noche"),
                    rs.getString("descripcion")
                ));
            }
        }
        return lista;
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM habitaciones WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Habitacion buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM habitaciones WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Habitacion(
                        rs.getInt("id"),
                        rs.getString("numero"),
                        TipoHabitacion.valueOf(rs.getString("tipo").toUpperCase()),
                        rs.getInt("capacidad"),
                        rs.getDouble("precio_noche"),
                        rs.getString("descripcion")
                    );
                }
            }
        }
        return null;
    }
}
