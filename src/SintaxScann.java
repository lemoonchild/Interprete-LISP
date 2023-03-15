

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        } else if (Parts[0].equalsIgnoreCase("(atom") || Parts[1].equalsIgnoreCase("atom")) {
            return 4; // ¿será una lista? - PREDICADO
        } else if (Parts[0].equalsIgnoreCase("(equal") || Parts[1].equalsIgnoreCase("equal")) {
            return 5; // ¿elementos iguales? - PREDICADO
        } else if (Parts[0].equalsIgnoreCase("(<") || Parts[1].equalsIgnoreCase("<")) {
            return 6; // Menor que - PREDICADO
        } else if (Parts[0].equalsIgnoreCase("(>") || Parts[1].equalsIgnoreCase(">")) {
            return 7; // Mayor que - PREDICADO
        } else if (Parts[0].equalsIgnoreCase("(list") || Parts[1].equalsIgnoreCase("list")) {
            return 8; // Crear una list
        } else {
            return 0; // Invalid action
        }

        // FALTANTE OPERACIONES ARITMÉTICAS, PREDICADOS Y CONDICIONES
    }

    public boolean evalateOperation(String regex, String expression) {

        String newExpression = expression.replace("(", "");
        newExpression = expression.replace(")", "");

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(newExpression);

        return matcher.find();
    }
}