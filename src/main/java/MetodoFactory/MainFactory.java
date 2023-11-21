package MetodoFactory;


import DAOS.DAOProducto;
import Entidades.Producto;

import java.sql.SQLException;
import java.util.List;

public class MainFactory {
    public static void main(String[] args) throws SQLException {
       // Producto producto1 = new Producto(1,"Zapatillas Nike",2000,3);
        //Producto producto2 = new Producto(2,"Zapatillas Adidas",3000,1);

        DAOProducto daoProducto = new DAOProducto();

        //daoProducto.GuardarProducto(producto1);
        //daoProducto.GuardarProducto(producto2);

        List<Producto> productos = daoProducto.ListarProductos();
        System.out.println("Product size ==> " + productos.size());
        for(Producto producto : productos){
            System.out.println(producto.getNombre());
        }
    }
}
