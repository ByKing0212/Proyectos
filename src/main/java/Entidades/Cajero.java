package Entidades;

public class Cajero {
    private DetalleOrden detalleOrden;
    private Cliente cliente;
    private Factura factura;

    public Cajero(DetalleOrden detalleOrden, Cliente cliente, Factura factura) {
        this.detalleOrden = detalleOrden;
        this.cliente = cliente;
        this.factura = factura;
    }

    public DetalleOrden getDetalleOrden() {
        return detalleOrden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setDetalleOrden(DetalleOrden detalleOrden) {
        this.detalleOrden = detalleOrden;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
