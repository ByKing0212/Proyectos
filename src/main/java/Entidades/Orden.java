package Entidades;

import java.util.Date;
public class Orden {
    private Date fecha;
    private DetalleOrden detalleOrden;
    private MetodoDePago metodoDePago;

    public Orden(DetalleOrden detalleOrden, MetodoDePago metodoDePago) {
        this.detalleOrden = detalleOrden;
        this.metodoDePago = metodoDePago;
    }
}
