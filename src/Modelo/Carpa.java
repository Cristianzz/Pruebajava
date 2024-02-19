package Modelo;

public class Carpa extends MedioDeAlojamiento{
    protected int cantidadPersonas;

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Carpa(int valorBaseNoche, int cantidadNoches, String tipoTemporada, DatosCliente datoscliente, int cantidadPersonas) {
        super(valorBaseNoche, cantidadNoches, tipoTemporada, datoscliente);
        this.cantidadPersonas = cantidadPersonas;
    }

    @Override
    public int subTotal() {
        return Math.round(this.cantidadNoches*valorBaseNoche);
    }

    @Override
    public int cobroExtraporNoches() { return 0;}

    @Override
    public int valorACancelar() {
        int valorAcancelar;

        valorAcancelar = this.subTotal()-this.bonoDescuento();

        return valorAcancelar;
    }
}
