package Entidades;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Orden> ordenes;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        ordenes = new ArrayList<Orden>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void agregarOrden(Orden orden) {
        ordenes.add(orden);
    }
    public void mostrarOrdenes(Orden orden) {
        for(Orden elemento : ordenes){
            System.out.println();
        }
    }
}
