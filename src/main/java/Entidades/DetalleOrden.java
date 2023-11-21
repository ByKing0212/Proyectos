package Entidades;
import java.util.ArrayList;

public class DetalleOrden {
    private ArrayList<Producto> productos;

    public DetalleOrden() {
        this.productos = new ArrayList<Producto>();
    }

    public void agregarProductos(Producto producto){
        if(producto.getCantidadStock() > 0){
            this.productos.add(producto);
            producto.setCantidadStock(producto.getCantidadStock() - 1);
        }
        else {
            System.out.println("No hay suficientes productos en Stock");
        }
    }

    public ArrayList<Producto> getProductos(){
        return this.productos;
    }

    public float calcularPrecioTotal(){
        float total = 0;
        for(Producto producto : this.productos){
            total += producto.getPrecio();
        }
        return total;
    }

    @Override
    public String toString() {
        String productosS = "";
        for(Producto producto : this.productos){
            productosS += producto.toString() + "\n";
        }
        return productosS;
    }
}
