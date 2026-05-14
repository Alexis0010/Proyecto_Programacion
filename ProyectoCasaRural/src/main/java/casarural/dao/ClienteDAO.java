package casarural.dao;

import casarural.model.Cliente;
import casarural.util.DatabaseConnection;

import java.sql.*;

public class ClienteDAO {

    public void insertar(Cliente c) throws SQLException {
        String sql = "INSERT INTO clientes (nombre, telefono, email, dni) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getDni());
            ps.executeUpdate();
        }
    }
}
