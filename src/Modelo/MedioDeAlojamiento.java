package Modelo;

public abstract class MedioDeAlojamiento {
    protected int valorBaseNoche;
    protected int cantidadNoches;
    protected String TipoTemporada;

    protected DatosCliente datoscliente;

    public int getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(int valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    public String getTipoTemporada() {
        return TipoTemporada;
    }

    public void setTipoTemporada(String tipoTemporada) {
        TipoTemporada = tipoTemporada;
    }

    public DatosCliente getDatoscliente() {
        return datoscliente;
    }

    public void setDatoscliente(DatosCliente datoscliente) {
        this.datoscliente = datoscliente;
    }

    public MedioDeAlojamiento(int valorBaseNoche, int cantidadNoches, String tipoTemporada, DatosCliente datoscliente) {
        this.valorBaseNoche = valorBaseNoche;
        this.cantidadNoches = cantidadNoches;
        TipoTemporada = tipoTemporada;
        this.datoscliente = datoscliente;
    }

    public abstract int subTotal ();
    public abstract int cobroExtraporNoches();
    public int bonoDescuento (){
        int bono = 0;

        if (this.TipoTemporada.equalsIgnoreCase("Baja")) {
            bono = (int) Math.round(this.subTotal() * 0.25);
        } else if (this.TipoTemporada.equalsIgnoreCase("Media")) {
            bono = (int) Math.round(this.subTotal() * 0.125);
        }else if(this.getTipoTemporada().equalsIgnoreCase("alta")) {
            bono = 0;
        }
        return bono;
    }

    public abstract int valorACancelar();
}
