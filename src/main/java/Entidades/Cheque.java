package Entidades;

public class Cheque extends MetodoDePago {
    private String nombre;
    private String bancoId;

    public Cheque(float cantidadPorPagar, String nombre, String bancoId) {
        super(cantidadPorPagar);
        this.nombre = nombre;
        this.bancoId = bancoId;
    }

    //no se si aprobado hacerlo una variable bool y ya
    public void aprobado(){
        System.out.println("Pago Aprobado");
    }
}