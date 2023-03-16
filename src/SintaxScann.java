
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * SintaxScann
 */
public class SintaxScann {
    Scanner sc = new Scanner(System.in);

    /**
     * Permite leer linea por linea cierto código y decidir la acción a tomar.
     * 
     * @param lines
     */
    public void Read(ArrayList<String> lines) {
        String[] Parts;
        int cont = 0;
        for (String string : lines) {
            if (lines.size() != 1) { // Si son varias líneas de código
                if (cont == 0) {
                    Decide_action(string);
                } else {
                    Parts = string.split(" ");
                }
                cont++;
            } else { // Al contar solo una línea de código
                Decide_action(string); // Escoger acción a realizar
                Parts = string.split("\\s|(?<=\\()|(?=\\))"); // Dividir paréntesis

            }
        }
    }

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
        } else if (Parts[0].equalsIgnoreCase("(cond") || Parts[1].equalsIgnoreCase("cond")) {
            return 2; // Condiciones
        } else if (Parts[0].equalsIgnoreCase("(setq") || Parts[1].equalsIgnoreCase("setq")) {
            return 3; // asignar valor a una variable
        } else if (Parts[0].equalsIgnoreCase("(quote") || Parts[1].equalsIgnoreCase("quote")
                || Parts[0].indexOf("'") == 0) {
            return 4; // Tomar datos literales
        } else if (Parts[0].equalsIgnoreCase("(atom") || Parts[1].equalsIgnoreCase("atom")) {
            return 5; // ¿será una lista? - PREDICADO
        } else if (Parts[0].equalsIgnoreCase("(equal") || Parts[1].equalsIgnoreCase("equal")) {
            return 6; // ¿elementos iguales? - PREDICADO
        } else if (Parts[0].equalsIgnoreCase("(<") || Parts[1].equalsIgnoreCase("<")) {
            return 7; // Menor que - PREDICADO
        } else if (Parts[0].equalsIgnoreCase("(>") || Parts[1].equalsIgnoreCase(">")) {
            return 8; // Mayor que - PREDICADO
        } else if (Parts[0].equalsIgnoreCase("(list") || Parts[1].equalsIgnoreCase("list")) {
            return 9; // Crear una list
        } else {
            return 0; // Invalid action
        }

        // FALTANTE OPERACIONES ARITMÉTICAS Y CONDICIONES
    }

    public boolean evalateOperation(String regex, String expression) {

        String newExpression = expression.replace("(", "");
        newExpression = expression.replace(")", "");

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(newExpression);

        return matcher.find();
    }
}