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
    public void ingresarCabagna(Cabagna cabagna){
        if (buscarAlojamiento(cabagna.getDatoscliente().getDNI())==-1 ){
            medioAlojamiento.add(cabagna);
        }
    }

    public void ingresarHotel(Hotel hotel){
        if (buscarAlojamiento(hotel.getDatoscliente().getDNI())==-1){
            medioAlojamiento.add(hotel);
        }
    }


    public void mostrarTodosLosAlojamientos() {
        for (MedioDeAlojamiento alojamiento : medioAlojamiento) {
              if (alojamiento instanceof Carpa) {
                  Carpa carpa = (Carpa) alojamiento;
                  System.out.println("------------------Carpas-------------------");
                  System.out.println("Tipo: Carpa, Cantidad de personas: " + carpa.getCantidadPersonas() + ", Temporada: " + carpa.getTipoTemporada() + ", Cantidad de noches: " + carpa.getCantidadNoches() + ", Valor Base: " + carpa.getValorBaseNoche());
              }else if (alojamiento instanceof Hotel) {
                  Hotel hotel = (Hotel) alojamiento;
                  System.out.println("------------------Hoteles-------------------");
                  System.out.println("Tipo: Hotel, Capacidad: " + hotel.getCapacidad() + ", Temporada: " + hotel.getTipoTemporada() + " , Es fumador: " + hotel.isFumador() + " , Cantidad de noches: " + hotel.getCantidadNoches() + ",Con Desayuno: " + hotel.isDesayuno() + ",alor base: $"+hotel.getValorBaseNoche());
              } else if (alojamiento instanceof Cabagna) {
                  Cabagna cabagna = (Cabagna) alojamiento;
                  System.out.println("------------------Cabañas-------------------");
                  System.out.println("Tipo: Cabaña, Capacidad: " + cabagna.getCapacidad() + ", Temporada: " + cabagna.getTipoTemporada() + ", Es fumador: " + cabagna.isFumador() + ", Cantidad de noches: " + cabagna.getCantidadNoches() + ",Con Chimenea: " + cabagna.isChimenea() + ", Valor base: $" + cabagna.getValorBaseNoche());
             }
        }
    }

    public void mostrarDatosCliente(int DNI) {
        int dnicliente = buscarAlojamiento(DNI);

        if (dnicliente != -1) {
            MedioDeAlojamiento alojamientoCliente = medioAlojamiento.get(dnicliente);
            System.out.println("Cliente encontrado. Datos del alojamiento:");
            System.out.println("Nombre: " + alojamientoCliente.getDatoscliente().getNombre());
            System.out.println("Cantidad de noches: " + alojamientoCliente.getCantidadNoches());
            System.out.println("Temporada: "+alojamientoCliente.getTipoTemporada());
            System.out.println("Valor base: $"+alojamientoCliente.getValorBaseNoche());
            System.out.println("Subtotal por la cantidad de noches es: $"+alojamientoCliente.subTotal());
            if (alojamientoCliente instanceof Hotel) {
                boolean esFumador = ((Hotel) alojamientoCliente).isFumador();
                boolean quiereDesayuno = ((Hotel) alojamientoCliente).isDesayuno();

                System.out.println("Es Fumador: " + esFumador);
                System.out.println("Quiere Desayuno: " + quiereDesayuno);
                System.out.println("Tipo de alojamiento: Hotel");
            } else if (alojamientoCliente instanceof Cabagna) {
                boolean esFumador = ((Cabagna) alojamientoCliente).isFumador();
                boolean quiereChimenea = ((Cabagna) alojamientoCliente).isChimenea();
                System.out.println("Es Fumador: " + esFumador);
                System.out.println("Quiere Chimenea: " + quiereChimenea);
                System.out.println("Tipo de alojamiento: Cabaña");
            } else if (alojamientoCliente instanceof Carpa) {
                System.out.println("Tipo de alojamiento: Carpa");
              //  System.out.println("Este tipo de alojamiento no tiene opciones adicionales.");
            }



        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public int totalAdicional() {
        int totalAdicional = 0;

        for (MedioDeAlojamiento alojamientoCliente : medioAlojamiento) {
            if (alojamientoCliente instanceof Hotel) {
                Hotel hotel = (Hotel) alojamientoCliente;
                totalAdicional += hotel.adicional();
            } else if (alojamientoCliente instanceof Cabagna) {
                Cabagna cabagna = (Cabagna) alojamientoCliente;
                totalAdicional += cabagna.adicional();
            }
        }

        return totalAdicional;
    }

    public int totalBonoDescuentos(){

        int totalBonos = 0;

        for (MedioDeAlojamiento alojamientoCliente : medioAlojamiento){
            totalBonos += alojamientoCliente.bonoDescuento() ;
        }

        return totalBonos;
    }

    public int obtenerCantidadTotalMediosAlojamiento() {
        return medioAlojamiento.size();
    }

    public int obtenerCantidadHoteles() {
        int cantidadHoteles = 0;
        for (MedioDeAlojamiento alojamiento : medioAlojamiento) {
            if (alojamiento instanceof Hotel) {
                cantidadHoteles++;
            }
        }
        return cantidadHoteles;
    }

    public int obtenerCantidadCabagnas() {
        int cantidadCabagnas = 0;
        for (MedioDeAlojamiento alojamiento : medioAlojamiento) {
            if (alojamiento instanceof Cabagna) {
                cantidadCabagnas++;
            }
        }
        return cantidadCabagnas;
    }

    public int obtenerCantidadCarpas() {
        int cantidadCarpas = 0;
        for (MedioDeAlojamiento alojamiento : medioAlojamiento) {
            if (alojamiento instanceof Carpa) {
                cantidadCarpas++;
            }
        }
        return cantidadCarpas;
    }

    public void valorCancelarCliente(int DNI) {
        int indiceCliente = buscarAlojamiento(DNI);

        if (indiceCliente != -1) {
            MedioDeAlojamiento alojamientoCliente = medioAlojamiento.get(indiceCliente);
            System.out.println("Cantidad de noches: " + alojamientoCliente.getCantidadNoches());
            System.out.println("Valor base: $"+alojamientoCliente.getValorBaseNoche());
            System.out.println("Tipo de temporada: "+alojamientoCliente.getTipoTemporada());
            System.out.println("El Subtotal a pagar por la cantidad de noches es: $"+alojamientoCliente.subTotal());

            if (alojamientoCliente instanceof Hotel) {
                Hotel hotel = (Hotel) alojamientoCliente;
                int totalAcancelar = alojamientoCliente.subTotal() - alojamientoCliente.bonoDescuento() + ((Hotel) alojamientoCliente).adicional();

                System.out.println("Es Fumador: " + hotel.isFumador());
                System.out.println("Quiere Desayuno: " + hotel.isDesayuno());
                System.out.println("Adicional: $" + hotel.adicional());
                System.out.println("Bono de Descuento: $" + alojamientoCliente.bonoDescuento());
                System.out.println("Total a cancelar: $" + totalAcancelar );
            } else if (alojamientoCliente instanceof Cabagna) {
                Cabagna cabagna = (Cabagna) alojamientoCliente;
                int totalAcancelar = alojamientoCliente.subTotal() - alojamientoCliente.bonoDescuento() + ((Cabagna) alojamientoCliente).adicional();

                System.out.println("Es Fumador: " + cabagna.isFumador());
                System.out.println("Quiere Chimenea: " + cabagna.isChimenea());
                System.out.println("Adicional: $" + cabagna.adicional());
                System.out.println("Bono de Descuento: $" + alojamientoCliente.bonoDescuento());
                System.out.println("Total a cancelar: $" + totalAcancelar);
            }

        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void aplicarIncrementoValorBase() {
        for (MedioDeAlojamiento alojamiento : medioAlojamiento) {
            if (alojamiento instanceof Cabagna) {
                Cabagna cabagna = (Cabagna) alojamiento;
                System.out.println("----------Cabaña-------------------------");
                if (cabagna.getCapacidad() > 5) {
                    System.out.println("la capacidad de la cabaña es superior a 5");
                    System.out.println("Se aumenta el valor base para el cliente : " + cabagna.getDatoscliente().getNombre());
                    cabagna.incrementaValorBase();
                    System.out.println("El valor base ahora es: " + cabagna.incrementaValorBase());
                }
            } else if (alojamiento instanceof Hotel) {
                Hotel hotel = (Hotel) alojamiento;
                System.out.println("----------------Hotel----------------------");
                if (hotel.getCapacidad() > 5) {
                    System.out.println("la capacidad de hotel es superior a 5");
                    System.out.println("Se aumenta el valor base para el cliente: " + hotel.getDatoscliente().getNombre());
                    hotel.incrementaValorBase();
                    System.out.println("El valor base ahora es: " + hotel.incrementaValorBase());
                }
            }
            // Puedes agregar más casos según los tipos de alojamiento que tengas
        }
    }


}