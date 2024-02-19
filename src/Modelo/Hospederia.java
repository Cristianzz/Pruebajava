package Modelo;

public abstract class Hospederia extends MedioDeAlojamiento{

    protected boolean fumador;
    protected int capacidad;

    public Hospederia(int valorBaseNoche, int cantidadNoches, String tipoTemporada, DatosCliente datoscliente, boolean fumador, int capacidad) {
        super(valorBaseNoche, cantidadNoches, tipoTemporada, datoscliente);
        this.fumador = fumador;
        this.capacidad = capacidad;
    }

    public boolean isFumador() {
        return fumador;
    }

    public void setFumador(boolean fumador) {
        this.fumador = fumador;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public int subTotal() {
        return Math.round(this.cantidadNoches*getValorBaseNoche());
    }
    public int cobroExtraporNoches(){return Math.round(this.cantidadNoches*incrementaValorBase());}
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public abstract int adicional ();


    public int incrementaValorBase(){
        int incremento = this.getValorBaseNoche();

        if (this.getCapacidad()>5){
            incremento = (int) (this.getValorBaseNoche() + Math.round(this.getValorBaseNoche()*0.18));
        }

        return incremento;
    }
}
