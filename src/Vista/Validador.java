package Vista;

public class Validador {
        public static boolean esNumero(String cadena) {
            try {
                Integer.parseInt(cadena);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        public static boolean esNumeroNegativo(String cadena) {
            if (esNumero(cadena)) {
                int numero = Integer.parseInt(cadena);
                return numero >= 0;
            }
            return false;
        }

        public static boolean esBooleano(String cadena) {
            return cadena.equalsIgnoreCase("true") || cadena.equalsIgnoreCase("false");
        }

        public static boolean contieneNumeros(String cadena) {
            for (char caracter : cadena.toCharArray()) {
                if (Character.isDigit(caracter)) {
                    return true;
                }
            }
            return false;
        }



}
