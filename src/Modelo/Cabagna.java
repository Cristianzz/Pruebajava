package Modelo;

public class Cabagna extends Hospederia {
   private boolean chimenea;

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }

    public Cabagna(int valorBaseNoche, int cantidadNoches, String tipoTemporada, DatosCliente datoscliente, boolean fumador, int capacidad, boolean chimenea) {
        super(valorBaseNoche, cantidadNoches, tipoTemporada, datoscliente, fumador, capacidad);
        this.chimenea = chimenea;
    }


    @Override
    public int adicional() {
        int adicional=0;

        if (this.fumador || this.chimenea){
            adicional = Math.round(this.subTotal() * 30 / 100);
        }
        return adicional;
    }


    @Override
    public int valorACancelar() {
        int valorAcancelar;

        valorAcancelar=this.subTotal()+this.adicional()-this.bonoDescuento();

        return valorAcancelar;
    }
}

