package MetodoFactory;

import Util.PropertiesUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class DBFactory {
    private static final String DB_FACTORY_PROPERTY_URL = "C:\\Users\\huert\\OneDrive\\Documentos\\Yo\\Yo\\Universidad\\TECNOLOGIAS\\Proyectos\\src\\main\\java\\Propiedades\\DBFactory.properties";
    private static final String DEFAULT_DB_CLASS_PROP = "defaultDBClass";

    private static DBFactory instance; // Instancia única de la clase
    private IDBAdapter idbAdapter;

    private DBFactory() {
        // Constructor privado para evitar la creación de instancias externas
        try {
            Properties prop = PropertiesUtil.loadProperty(DB_FACTORY_PROPERTY_URL);
            String defaultDBClass = prop.getProperty(DEFAULT_DB_CLASS_PROP);
            System.out.println("Base de datos escogida ==> " + defaultDBClass);
            Class<?> clazz = Class.forName(defaultDBClass);
            this.idbAdapter = (IDBAdapter) clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            e.printStackTrace();
            // Manejar la excepción de inicialización de la base de datos
        }
    }

    public static synchronized DBFactory getInstance() {
        if (instance == null) {
            instance = new DBFactory();
        }
        return instance;
    }

    public IDBAdapter getDefaultDBAdapter() {
        return idbAdapter;
    }
}
