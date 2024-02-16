package Vista;

import Controlador.Alojamiento;
import Modelo.Cabagna;
import Modelo.Carpa;
import Modelo.DatosCliente;
import Modelo.Hotel;

import java.util.ArrayList;

public class Tests {
    public static void main(String[] args) {
        DatosCliente datoscliente = new DatosCliente("Jorge",7766);
        DatosCliente datoscliente1 = new DatosCliente("Juan",7766);
        DatosCliente datoscliente2 = new DatosCliente("Joel",7766);

        Carpa tipocarpa = new Carpa(100,5,"baja",datoscliente,5);
        Cabagna tipocabagna = new Cabagna(100,6,"baja",datoscliente1,true,6,true);
        Cabagna tipocabagna1 = new Cabagna(100,6,"baja",datoscliente1,true,6,true);
        Hotel tipohotel = new Hotel(100,8,"Media",datoscliente2,false,15,true);

        Alojamiento alojamiento=new Alojamiento(new ArrayList<>());

        System.out.println("La cantidad de calzados es: "+ alojamiento.getMedioAlojamiento().size());

        alojamiento.ingresarCabania(tipocabagna);

        System.out.println("La cantidad de calzados es: "+ alojamiento.getMedioAlojamiento().size());

        alojamiento.ingresarCabania(tipocabagna1);

        System.out.println("La cantidad de calzados es: "+ alojamiento.getMedioAlojamiento().size());

    }
}
