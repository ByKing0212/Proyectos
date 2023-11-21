package Entidades;

public class TCredito extends MetodoDePago {
    private String numeroCC, tipo, fechaExp, cvv;

    public TCredito(float cantidadPorPagar, String numeroCC, String tipo, String fechaExp, String cvv) {
        super(cantidadPorPagar);
        this.numeroCC = numeroCC;
        this.tipo = tipo;
        this.fechaExp = fechaExp;
        this.cvv = cvv;
    }

    //no se si aprobado hacerlo una variable bool y ya
    public void aprobado(){
        System.out.println("Pago aprobado");
    }
}
