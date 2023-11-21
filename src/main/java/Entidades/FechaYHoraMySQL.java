package Entidades;

import MetodoFactory.DBFactory;
import MetodoFactory.IDBAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FechaYHoraMySQL implements FechaYHora {
    private IDBAdapter idbAdapter;

    public FechaYHoraMySQL() {
        try {
            this.idbAdapter = DBFactory.getInstance().getDefaultDBAdapter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String obtenerHoraYFecha() {
        try (Connection connection = idbAdapter.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT CURRENT_TIMESTAMP as fecha_hora");
             ResultSet resultSet = statement.executeQuery()) {

            String fechaYHora = null;
            if (resultSet.next()) {
                fechaYHora = resultSet.getString("fecha_hora");
            }

            return fechaYHora;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al obtener la fecha y la hora de la base de datos";
        }
    }
}
