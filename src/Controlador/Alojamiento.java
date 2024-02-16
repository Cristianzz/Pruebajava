package Controlador;

import Modelo.Cabagna;
import Modelo.Carpa;
import Modelo.Hotel;
import Modelo.MedioDeAlojamiento;

import java.util.ArrayList;

public class Alojamiento {
  private ArrayList<MedioDeAlojamiento>medioAlojamiento;

    public ArrayList<MedioDeAlojamiento> getMedioAlojamiento() {
        return medioAlojamiento;
    }

    public void setMedioAlojamiento(ArrayList<MedioDeAlojamiento> medioAlojamiento) {
        this.medioAlojamiento = medioAlojamiento;
    }

    public Alojamiento(ArrayList<MedioDeAlojamiento> medioAlojamiento) {
        this.medioAlojamiento = medioAlojamiento;
    }

    public int buscarAlojamiento(int DNI){
        for (int i=0; i<medioAlojamiento.size();i++){
            if (medioAlojamiento.get(i).getDatoscliente().getDNI() == DNI){
                return i;
            }
        }
        return -1;
    }

    public void ingresarCarpa(Carpa carpa){
        if (buscarAlojamiento(carpa.getDatoscliente().getDNI())==-1){
            medioAlojamiento.add(carpa);
        }
    }
    public void ingresarCabania(Cabagna cabagna){
        if (buscarAlojamiento(cabagna.getDatoscliente().getDNI())==-1 ){
            medioAlojamiento.add(cabagna);
        }
    }

    public void ingresarHotel(Hotel hotel){
        if (buscarAlojamiento(hotel.getDatoscliente().getDNI())==-1){
            medioAlojamiento.add(hotel);
        }
    }




}
