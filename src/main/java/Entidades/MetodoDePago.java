package Entidades;

public abstract class MetodoDePago {
    protected float cantidadPorPagar;

    public MetodoDePago(float monto) {
        this.cantidadPorPagar = monto;
    }
}


