package DAOS;


import MetodoFactory.DBFactory;
import Entidades.Producto;
import MetodoFactory.IDBAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProducto {
    private IDBAdapter idbAdapter;


    public DAOProducto() {
        try {
            // Inicializar idbAdapter correctamente utilizando la fábrica
            this.idbAdapter = DBFactory.getInstance().getDefaultDBAdapter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Producto> ListarProductos() {
        List<Producto> productos = new ArrayList<>();
        try (Connection connection = idbAdapter.getConnection()) {
            String sql = "SELECT * FROM Productos1";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    Producto producto= new Producto(results.getInt("id"),results.getString("nombre"),results.getFloat("precio"),results.getInt("cantidadStock"));
                    productos.add(producto);
                }
            }
            catch (SQLException e) {
                System.err.println("Error al listar los productos en la base de datos: " + e.getMessage());
            }
            finally {
                connection.setAutoCommit(true);
                connection.close();
            }
            return productos;
        }
        catch (SQLException e) {
            System.err.println("No se pudo listar los productos: " + e.getMessage());
            return null;
        }
    }

    public boolean GuardarProducto(Producto producto) {
        Connection connection = idbAdapter.getConnection();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO Productos1(id, nombre, precio, cantidadStock) VALUES (?,?,?,?)");
            statement.setInt(1, producto.getId());
            statement.setString(2, producto.getNombre());
            statement.setFloat(3, producto.getPrecio());
            statement.setInt(4, producto.getCantidadStock());
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