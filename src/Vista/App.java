package Vista;
import Controlador.Alojamiento;
import Modelo.Carpa;
import Modelo.Hotel;
import Modelo.Cabagna;
import  Modelo.DatosCliente;

import  java.util.ArrayList;
public class App {

    public static void main(String[] args) {
        int opcion;
        int DNIcliente = 0;

        Alojamiento alojamiento = new Alojamiento(new ArrayList<>());

        do {
            opcion = menu();
            switch (opcion){
                case 1:
                    DNIcliente = pideDNI();

                    if (alojamiento.buscarAlojamiento(DNIcliente)==-1){
                        System.out.println("Ingrese nombre del cliente: "); String nombre = Leer.dato();
                        System.out.println("¿Cantidad de noches? "); int noches = Leer.datoInt();
                        System.out.println("¿Valor base noche? "); int valorBase = Leer.datoInt();

                        String temporada;
                        do {
                            System.out.println("Ingrese el tipo de temporada (alta, media o baja)");
                            temporada = Leer.dato();
                        }while (temporada.compareToIgnoreCase("Baja") !=0 && temporada.compareToIgnoreCase("Media") !=0 &&
                                temporada.compareToIgnoreCase("Alta") !=0);

                        int respuesta;
                        do {
                            System.out.println("\n El Tipo de alojamiento a ingresar es: 1) Carpa    2) Hotel    3) Cabaña");
                            System.out.println("-----------------------------------------------------");
                            System.out.println("Favor ingrese una opción para continuar...");
                            System.out.println("-----------------------------------------------------");
                            respuesta = Leer.datoInt(); //3
                        }while(respuesta< 1 || respuesta > 3);


                        if (respuesta ==1){
                            System.out.println("Cantidad de personas"); int cantidad=Leer.datoInt();
                            alojamiento.ingresarCarpa(new Carpa(valorBase,noches,temporada,new DatosCliente(nombre,DNIcliente),noches));
                            System.out.println("Registro exitoso del alojamiento");
                        }else {
                            System.out.println("¿Es fumador (true / false)?"); boolean fumador = Leer.datoBoolean();
                            System.out.println("Capacidad"); int capacidad=Leer.datoInt();
                            if (respuesta == 2){
                                System.out.println("¿Con desayuno (true / false)?"); boolean desayuno = Leer.datoBoolean();
                                alojamiento.ingresarHotel(new Hotel(valorBase,noches,temporada,new DatosCliente(nombre,DNIcliente),fumador,capacidad,desayuno));
                                System.out.println("Registro exitoso del alojamiento");
                            }else {
                                System.out.println("¿Con chimenea (true / false)?");boolean chimenea = Leer.datoBoolean();
                                alojamiento.ingresarCabagna(new Cabagna(valorBase,noches,temporada,new DatosCliente(nombre,DNIcliente),fumador,capacidad,chimenea));
                                System.out.println("Registro exitoso del alojamiento");
                            }

                        }
                    }else {
                        System.out.println("El DNI "+ DNIcliente + "Se encuentra registrado a otro alojamiento");
                    }
                    break;
                case 2:
                    System.out.println("--------------Alojamientos----------------");
                    alojamiento.mostrarTodosLosAlojamientos();
                    break;
                case 3:
                    int DNI = pideDNI();
                    System.out.println("--------Datos del cliente---------" );
                    alojamiento.mostrarDatosCliente(DNI);
                    break;
                case 4:
                    System.out.println("--------Total adicional de todos los alojamientos---------" );
                    System.out.println("Total Adicional: $" + alojamiento.totalAdicional());
                    break;
                case 5:
                    System.out.println("--------Total bono descuent de todos los alojamientos---------" );
                    System.out.println("Total de bonos de descuento: $"+alojamiento.totalBonoDescuentos());
                    break;
                case 6:
                    System.out.println("--------Cantidad de medios de alojamiento---------" );

                    System.out.println("Cantidad total de medios de alojamiento: " + alojamiento.obtenerCantidadTotalMediosAlojamiento());
                    System.out.println("Cantidad de hoteles: " + alojamiento.obtenerCantidadHoteles());
                    System.out.println("Cantidad de cabañas: " + alojamiento.obtenerCantidadCabagnas());
                    System.out.println("Cantidad de carpas: " + alojamiento.obtenerCantidadCarpas());
                    break;
                case 7:
                    int DNI1 = pideDNI();
                    System.out.println("----------Valor a cancelar----------");
                    alojamiento.valorCancelarCliente(DNI1);
                    break;
                case 8:
                    System.out.println("----------Incremento de valor base----------");
                    alojamiento.aplicarIncrementoValorBase();
                    break;
            }

        }while(opcion!=9);
    }

    public static int pideDNI(){
        System.out.println("Favor ingrese DNI del cliente");
        return Leer.datoInt();
    }

    public static int menu(){
        System.out.println("\n ------------ Servicio de Hoteleria -------------");
        System.out.println("1.\tIngresar medio de alojamiento (El ingreso puede ser Carpa, Hotel o Cabaña y solo se puede asociar un cliente por medio de alojamiento.)");
        System.out.println("2.\tMostrar medios de alojamiento");
        System.out.println("3.\tDatos de un cliente X (si existe, muestra donde está alojado y todos los datos asociados)");
        System.out.println("4.\tTotal adiciona");
        System.out.println("5.\tTotal bono descuento");
        System.out.println("6.\tCantidad medios de alojamiento X");
        System.out.println("7.\tValor a cancelar por un cliente X (el cliente debe existir).");
        System.out.println("8.\tAplicar incremento del valor base (donde corresponda) ");
        System.out.println("9.\tSalir.");
        System.out.println("-----------------------------------------------------");
        System.out.println("Favor ingrese una opción para continuar...");
        System.out.println("-----------------------------------------------------");
        return Leer.datoInt();
    }

}
