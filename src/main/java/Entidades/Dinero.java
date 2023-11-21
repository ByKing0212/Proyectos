package Entidades;

public class Dinero extends MetodoDePago {
    public float dineroEfectivo;
    public Dinero(float cantidadPorPagar, float dineroEfectivo) {
        super(cantidadPorPagar);
        this.dineroEfectivo = dineroEfectivo;
    }

    public float calcularVueltas(){
        return dineroEfectivo - cantidadPorPagar;
    }

}
