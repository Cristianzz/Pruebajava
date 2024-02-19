package Modelo;

public class Hotel extends Hospederia{
    private boolean desayuno;

    public boolean isDesayuno() {
        return desayuno;
    }

    public void setDesayuno(boolean desayuno) {
        this.desayuno = desayuno;
    }

    public Hotel(int valorBaseNoche, int cantidadNoches, String tipoTemporada, DatosCliente datoscliente, boolean fumador, int capacidad, boolean desayuno) {
        super(valorBaseNoche, cantidadNoches, tipoTemporada, datoscliente, fumador, capacidad);
        this.desayuno = desayuno;
    }


    @Override
    public int adicional() {
        int adicional=0;

        if (this.fumador && desayuno){
            adicional = Math.round(this.subTotal() * 30 / 100);
        }
        return adicional;
    }

    @Override
    public int valorACancelar() {
        int valorAcancelar;
        valorAcancelar = this.subTotal()+this.adicional()-this.bonoDescuento();

        return valorAcancelar;
    }
}
