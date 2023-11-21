package Entidades;

import MetodoFactory.DBFactory;
import MetodoFactory.IDBAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnionMySQL implements UnionDB {

    private IDBAdapter idbAdapter;

    public UnionMySQL() {
        try {
            this.idbAdapter = DBFactory.getInstance().getDefaultDBAdapter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> UnionCliente1Cliente2() {
        List<Cliente> clientes = new ArrayList<>();

        try (Connection connection = idbAdapter.getConnection();) {
            connection.setAutoCommit(false);
            String query = "SELECT * FROM clientetienda1 UNION SELECT * FROM clientetienda2;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Cliente cliente = new Cliente();
                        cliente.setId(resultSet.getInt("id"));
                        cliente.setCedula(resultSet.getInt("cedula"));
                        cliente.setNombre(resultSet.getString("nombre"));
                        cliente.setDireccion(resultSet.getString("direccion"));
                        cliente.setTelefono(resultSet.getString("telefono"));
                        clientes.add(cliente);
                    }
                }
                System.out.printf("| %-5s | %-10s | %-15s | %-20s | %-15s |\n",
                        "ID", "Cedula", "Nombre", "Direccion", "Telefono");
                System.out.println("|-------|------------|------------------|------------------------|------------------|");

                for (Cliente cliente : clientes) {
                    System.out.printf("| %-5d | %-10d | %-15s | %-20s | %-15s |\n",
                            cliente.getId(), cliente.getCedula(), cliente.getNombre(),
                            cliente.getDireccion(), cliente.getTelefono());
                }
            }
            catch (SQLException e) {
                System.err.println("Error al obtener los productos de la base de datos: " + e.getMessage());
            }
            finally {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException e) {
                    System.err.println("Error al restaurar el autocommit: " + e.getMessage());
                }
            }
            return clientes;
        }
        catch (SQLException e) {
            System.err.println("Error al obtener la conexión: " + e.getMessage());
            return null;
        }
    }
}
