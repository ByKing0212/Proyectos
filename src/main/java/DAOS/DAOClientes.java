package DAOS;

import Entidades.Cliente;
import MetodoFactory.DBFactory;
import MetodoFactory.IDBAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOClientes {
    private IDBAdapter idbAdapter;


    public DAOClientes() {
        try {
            // Inicializar idbAdapter correctamente utilizando la fábrica
            this.idbAdapter = DBFactory.getInstance().getDefaultDBAdapter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Cliente> ListarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection connection = idbAdapter.getConnection()) {
            String sql = "SELECT * FROM clientetienda1";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    Cliente cliente = new Cliente(results.getInt("id"),results.getInt("cedula"),results.getString("nombre"),results.getString("direccion"),results.getString("telefono"));
                    clientes.add(cliente);
                }
            }
            catch (SQLException e) {
                System.err.println("Error al listar los Clientes en la base de datos: " + e.getMessage());
            }
            finally {
                connection.setAutoCommit(true);
                connection.close();
            }
            return clientes;
        }
        catch (SQLException e) {
            System.err.println("No se pudo listar los Clientes: " + e.getMessage());
            return null;
        }
    }

    public boolean GuardarCliente1(Cliente cliente) {
        Connection connection = idbAdapter.getConnection();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO clientetienda1(id,cedula,nombre,direccion,telefono) VALUES (?,?,?,?,?)");
            statement.setInt(1, cliente.getId());
            statement.setFloat(2, cliente.getCedula());
            statement.setString(3, cliente.getNombre());
            statement.setString(4, cliente.getDireccion());
            statement.setString(5, cliente.getTelefono());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                // Manejo de excepciones
            }
        }
    }
    public boolean GuardarCliente2(Cliente cliente) {
        Connection connection = idbAdapter.getConnection();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO clientetienda2(id,cedula,nombre,direccion,telefono) VALUES (?,?,?,?,?)");
            statement.setInt(1, cliente.getId());
            statement.setFloat(2, cliente.getCedula());
            statement.setString(3, cliente.getNombre());
            statement.setString(4, cliente.getDireccion());
            statement.setString(5, cliente.getTelefono());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                // Manejo de excepciones
            }
        }
    }
}
