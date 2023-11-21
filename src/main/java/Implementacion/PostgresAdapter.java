package Implementacion;

import MetodoFactory.IDBAdapter;
import Util.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class PostgresAdapter implements IDBAdapter {
    private static final String DB_PROPIEDADES = "Propiedades/DBPostgreSQL.properties";
    private static final String DB_NAME_PROP = "dbname";
    private static final String DB_HOST_PROP = "host";
    private static final String DB_PASSWORD_PROP = "password";
    private static final String DB_PORT_PROP = "port";
    private static final String DB_USER_PROP = "user";

    @Override
    public Connection getConnection() {
        try {
            String connectionString = createConnectionString();
            Connection connection = DriverManager.getConnection(connectionString);
            System.out.println("Conexion clase ==> " + connection.getClass().getName());
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String createConnectionString() {
        Properties prop = PropertiesUtil.loadProperty(DB_PROPIEDADES);
        String host = prop.getProperty(DB_HOST_PROP);
        String port = prop.getProperty(DB_PORT_PROP);
        String db = prop.getProperty(DB_NAME_PROP);
        String user = prop.getProperty(DB_USER_PROP);
        String password = prop.getProperty(DB_PASSWORD_PROP);

        // Cambiar el controlador y la cadena de conexión para PostgreSQL
        String connectionString = "jdbc:postgresql://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + password;
        System.out.println("ConnectionString ==> " + connectionString);
        return connectionString;
    }
}
