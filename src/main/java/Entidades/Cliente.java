package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private int cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Orden> ordenes;

    public Cliente(int id, int cedula, String nombre, String direccion, String telefono) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        ordenes = new ArrayList<>();
    }
    public Cliente()
    {

    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ordenes=" + ordenes +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
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
