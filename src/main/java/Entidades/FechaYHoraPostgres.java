package Entidades;

import MetodoFactory.DBFactory;
import MetodoFactory.IDBAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FechaYHoraPostgres implements FechaYHora {
    private IDBAdapter idbAdapter;

    public FechaYHoraPostgres() {
        try {
            this.idbAdapter = DBFactory.getInstance().getDefaultDBAdapter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String obtenerHoraYFecha() {
        try {
            // Obtener una conexión a la base de datos
            Connection connection = idbAdapter.getConnection();

            // Consulta SQL para obtener la fecha y la hora
            String sql = "SELECT CURRENT_TIMESTAMP as fecha_hora";

            // Preparar la declaración SQL
            PreparedStatement statement = connection.prepareStatement(sql);

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Obtener la fecha y la hora del resultado
            String fechaYHora = null;
            if (resultSet.next()) {
                fechaYHora = resultSet.getString("fecha_hora");
            }

            // Cerrar recursos
            resultSet.close();
            statement.close();
            connection.close();

            return fechaYHora;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al obtener la fecha y la hora de la base de datos";
        }
    }
}
