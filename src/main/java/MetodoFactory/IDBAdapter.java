package MetodoFactory;

import java.sql.Connection;

public interface IDBAdapter {
    public Connection getConnection();
}
