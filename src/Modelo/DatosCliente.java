package Modelo;

public class DatosCliente {
    private String nombre;
    private int DNI;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public DatosCliente(String nombre, int DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }
}
