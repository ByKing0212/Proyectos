package MetodoFactory;


import DAOS.DAOProducto;
import Entidades.*;
import DAOS.DAOClientes;
import Implementacion.MySQLAdapter;

import java.sql.SQLException;
import java.util.List;

public class MainFactory {
    public static void main(String[] args) throws SQLException {
       //Producto producto1 = new Producto(1,"Zapatillas Nike",2000,3);
       //Producto producto2 = new Producto(2,"Zapatillas Adidas",3000,1);

        DAOProducto daoProducto = new DAOProducto();

        //daoProducto.GuardarProducto(producto1);
        //daoProducto.GuardarProducto(producto2);

        List<Producto> productos = daoProducto.ListarProductos();
        System.out.println("Product size ==> " + productos.size());
        for(Producto producto : productos){
            System.out.println(producto.getNombre());
        }
        //Cliente cliente1 = new Cliente(1,40403427,"Felipe","Carrera 5B","3214314131");
        //Cliente cliente2 = new Cliente(2,19403352,"Camilo","Carrera 8C","3125679823");

        DAOClientes daocliente = new DAOClientes();

        //daocliente.GuardarCliente1(cliente1);
        //daocliente.GuardarCliente1(cliente2);

        //Cliente cliente1 = new Cliente(3,100798320,"Laura","Carrera 25","3212312341");
        //Cliente cliente2 = new Cliente(2,103122320,"David","Calle 11","3123123223");

        //daocliente.GuardarCliente1(cliente1);
        //daocliente.GuardarCliente2(cliente2);

        /*UnionPostgres uniones = new UnionPostgres();
        System.out.println(uniones.UnionCliente1Cliente2());
        UnionPostgres uniones2 = new UnionPostgres();;
        System.out.println(uniones2.UnionCliente1Cliente2());
        DiferenciaPostgres diferenciaPostgres1 = new DiferenciaPostgres();
        System.out.println(diferenciaPostgres1.difCliente1Cliente2());
        DiferenciaMySQL diferenciaMySQL1 = new DiferenciaMySQL();
        System.out.println(diferenciaMySQL1.difCliente1Cliente2());*/
        FechaYHoraPostgres fechapost = new FechaYHoraPostgres();
        System.out.println(fechapost.obtenerHoraYFecha());
        FechaYHoraMySQL fechamysql = new FechaYHoraMySQL();
        System.out.println(fechamysql.obtenerHoraYFecha());
    }
}
