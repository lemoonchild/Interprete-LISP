
import java.util.ArrayList;
import java.util.Scanner;

/**
 * SintaxScann
 */
public class SintaxScann {
    Scanner sc = new Scanner(System.in);

    /**
     * Según lo escrito por el usuario permiete reconocer lo siguiente a realizarse
     * 
     * @return Entero que representa la acción que se realizará
     * @param solicita la entrada de la primera línea de código de una funcion
     *                 por el usuario
     */
    public int Decide_action(String action) {

        String[] Parts = action.split(" ");

        if (Parts[0].equalsIgnoreCase("(defun") || Parts[1].equalsIgnoreCase("defun")) {
            return 1; // Definir función
        } else if (Parts[0].equalsIgnoreCase("(setq") || Parts[1].equalsIgnoreCase("setq")) {
            return 2; // asignar valor a una variable
        } else if (Parts[0].equalsIgnoreCase("(quote") || Parts[1].equalsIgnoreCase("quote")
                || Parts[0].indexOf("'") == 0) {
            return 3; // Tomar datos literales
        } else {
            return 0; // Invalid action
        }

        // FALTANTE OPERACIONES ARITMÉTICAS, PREDICADOS Y CONDICIONES
    }

    /*
     * Permite reconocer cuando empieza y termina el uso de una función especial,
     * reconociendo sus paréntesis.
     * 
     * Además retorna el código de esa función a través de un arraylist, que luego
     * será interpretado.
     */
    public ArrayList<String> special_function() {

        int abre_parentesis = 0;
        int cierra_parentesis = 0;
        ArrayList<String> sf = new ArrayList<String>();

        do {
            String line = sc.nextLine();
            sf.add(line);
            String[] chars = line.split("");
            if (chars.equals("(")) {
                abre_parentesis += 1;
            } else if (chars.equals(")")) {
                cierra_parentesis += 1;
            } else {
                continue;
            }
        } while (abre_parentesis != cierra_parentesis);

        return sf;
    }
}